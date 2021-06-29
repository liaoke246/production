package com.youkeda.app.service.impl;

import com.youkeda.app.dao.VotesDAO;
import com.youkeda.app.dataobject.VotesDO;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketPurchaseServiceImpl implements TicketPurchaseService {
    @Autowired
    private VotesDAO votesDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result<Boolean> ticketPurchase(long id) {
        //初始化返回数据
        Result result = new Result();
        result.data(true);
        result.setSuccess(true);
        //实现购买代码

        Object value = redisTemplate.opsForValue().get(id);
        int stock = 0;
        if(value == null){
            VotesDO votesDO = votesDAO.selectById(id);
            stock = votesDO.getStock();
            redisTemplate.opsForValue().set(votesDO.getId(),stock);
        }else{

            stock = (int)value;
        }
    redisTemplate.execute(new SessionCallback<List<Object>>() {
        @Override
        public List<Object> execute(RedisOperations operations) throws DataAccessException {
        Integer stock = (Integer)operations.opsForValue().get(id);
            if(Integer.valueOf(stock) >= 1 ){
                operations.watch(id);

                operations.multi();

                operations.opsForValue().set(id,stock - 1);

                VotesDO votesDO = new VotesDO();
                votesDO.setId(id);
                votesDO.setStock(stock - 1);
                votesDAO.updateStock(votesDO);
            //执行事务
                List exec = operations.exec();
                    if(exec.size() > 0){
                        result.setSuccess(true);
                        result.setMessage("抢购成功");

                    }else{
                        result.setSuccess(false);
                        result.setMessage("抢购失败");

                    }


            }else{
                result.setMessage("库存不足");
                result.setSuccess(false);

            }
            return null;
        }
    });




        return result;
    }

}

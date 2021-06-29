package com.youkeda.app.service.impl;

import com.youkeda.app.dataobject.ProductDO;
import com.youkeda.app.dao.ProductDAO;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.SnappedUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnappedUpServiceImpl implements SnappedUpService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result<Boolean> snappedUp(Long id) {
        //初始化返回数据
        Result result = new Result();
        result.data(true);
        result.setSuccess(true);
        //实现购买代码
    
   ProductDO productDO = productDAO.selectById(id);
      if(productDO.getPrice() > 1){
        productDO.setPrice(productDO.getPrice() - 1);
        
        productDAO.updateStock(productDO);
      }else{
        
       result.setSuccess(false); 
      }
 

        return result;
    }

}

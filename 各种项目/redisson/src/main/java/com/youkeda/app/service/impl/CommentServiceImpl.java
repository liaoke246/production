package com.youkeda.app.service.impl;

import com.youkeda.app.dao.CommentDAO;
import com.youkeda.app.dataobject.CommentDO;
import com.youkeda.app.service.CommentService;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @date 2020/6/16, 周二
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public Integer add(CommentDO commentDO) {
        String autoIncrId = getAutoIncrId();

        if(autoIncrId != null && autoIncrId.length() != 16){
            return 0;
        }
        commentDO.setId(autoIncrId);

        return commentDAO.insert(commentDO);
    }

    private String getAutoIncrId() {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

      String now = LocalDate.now().format(dateTimeFormatter);
      
      RAtomicLong atomicLong = redissonClient.getAtomicLong(now);

      atomicLong.expire(1,TimeUnit.DAYS);

      String fa = String.format("%08d",atomicLong.incrementAndGet());
      
        return now + "" + fa;
    }

}

package com.youkeda.app.service.impl;

import com.youkeda.app.dao.CommentDAO;
import com.youkeda.app.dataobject.CommentDO;
import com.youkeda.app.service.CommentService;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public Integer add(CommentDO commentDO) {
        commentDO.setId(getAutoIncrId());
        return commentDAO.insert(commentDO);
    }

    @Override
    public Integer addLike(String commentId) {
        //获取分布式锁
      RLock transferLock = redissonClient.getLock("likes");
      
      transferLock.lock();
      
      try{
        CommentDO commentDO = commentDAO.selectByPrimaryKey(commentId);

        commentDO.setLikes(commentDO.getLikes() - 1);
        commentDAO.updateByPrimaryKey(commentId);

      }catch (Exception e){
          logger.error("",e);
      }finally {

      }
      

        return 0;
    }

    private String getAutoIncrId() {
        //格式化格式为年月日
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 获取当前时间字符串形式
        String now = LocalDate.now().format(dateTimeFormatter);

        //根据当前时间来获取key为时间的自增数
        RAtomicLong atomicLong = redissonClient.getAtomicLong(now);
        //格式化字符串
        String formatLong = String.format("%08d", atomicLong.incrementAndGet());
        atomicLong.expire(1, TimeUnit.DAYS);
        return now + "" + formatLong;
    }

}

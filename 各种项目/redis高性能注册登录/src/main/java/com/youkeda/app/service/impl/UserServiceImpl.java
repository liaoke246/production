package com.youkeda.app.service.impl;

import com.youkeda.app.dao.UserDAO;
import com.youkeda.app.dataobject.UserDO;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Result<Boolean> add(UserDO userDO) {
        Result<Boolean> result = new Result<>();
        String code = String.valueOf((int)(Math.random() * 9 + 1) * 100000);
        redisTemplate.opsForValue().set("email",code,5, TimeUnit.MINUTES);
        result.setData(false);
        if (userDO == null) {
            return result;
        }

        //判断是否输入手机号和密码 必填字段
        if (StringUtils.isEmpty(userDO.getPassword())) {
            result.setMessage("请填写密码");
            return result;
        }

        if(StringUtils.isEmpty(userDO.getEmail())){
            result.setMessage("请填写邮箱");
                return  result;
        }
        if(userDAO.selectByEmail(userDO.getEmail()) != null){
            result.setMessage("该邮箱已被注册");
            return result;

        }



    //发邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2860215725@qq.com");
        message.setTo(userDO.getEmail());
        message.setSubject("发送验证码");
        message.setText(code);

        result.setSuccess(true);
        return result;

    }
}

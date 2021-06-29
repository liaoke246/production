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
        result.setSuccess(true);
        if (userDO == null) {
            result.setData(false);
            return result;
        }

        //判断是否输入手机号和密码 必填字段
        if (StringUtils.isEmpty(userDO.getPassword())) {
            System.out.println("请填写密码");
            result.setData(false);
            return result;
        }

        if (StringUtils.isEmpty(userDO.getEmail())) {
            System.out.println("请填写邮箱");
            result.setData(false);
            return result;
        }

        //每次先去redis校验
        String pwd = (String)redisTemplate.opsForValue().get(userDO.getEmail());
        //当redis没有数据的时候再去数据库查询
        if (StringUtils.isEmpty(pwd)) {
            UserDO user = userDAO.selectByEmail(userDO.getEmail());
            if (user != null) {
                System.out.println("该邮箱已被注册");
                result.setData(false);
                return result;
            }
        }

        //这里模拟验证码发送 我们生成6位验证码存到 redis并且设置过期时间
        int code = (int)(Math.random() * 1000000);
        //发送邮箱验证码
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userDO.getEmail());
        message.setTo(userDO.getEmail());
        message.setSubject("注册验证码");
        message.setText("注册验证码为" + code);
        mailSender.send(message);
        //设置验证码在redis中的过期时间
        redisTemplate.opsForValue().set("code", String.valueOf(code), 1000, TimeUnit.SECONDS);

        //拿到用户收到的验证码，和我们redis里的比较，这里就不模拟了
        //验证码比对成功 注册成功插入数据库
        int insert = userDAO.insert(userDO);
        if (insert != 1) {
            System.out.println("插入失败");
            result.setData(false);
            return result;
        }

        //将密码缓存到redis里(键是邮箱，值是密码)
        redisTemplate.opsForValue().set(userDO.getEmail(), userDO.getPassword());

        return result;
    }

    @Override
    public Result<Boolean> login(String email, String password) {
        Result<Boolean> result = new Result<>();
        result.setSuccess(true);

        //判断邮箱和密码是否为空
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            System.out.println("邮箱和密码不能为空");
            result.setData(false);
            return result;
        }
        //先去redis校验
        String pas=(String) redisTemplate.opsForValue().get(email);
        //如果redis没有则去数据库校验
        if(pas==null){
            //根据邮箱去数据库查询
            UserDO userDO = userDAO.selectByEmail(email);
            //判断有没有该用户
            if (userDO == null) {
                System.out.println("没有该用户");
                result.setData(false);
                return result;
            }
            //将查询到的结果缓存到 redis
            redisTemplate.opsForValue().set(userDO.getEmail(),userDO.getPassword());
            //判断密码是否正确
            if (!userDO.getPassword().equals(password)) {
                System.out.println("密码不正确");
                result.setData(false);
                return result;
            }

            System.out.println("登录成功");
            result.setData(true);
            return result;
        }else{
            //能查到则根据redis校验
            if(pas.equals(password)){
                System.out.println("登录成功");
                result.setData(true);
                return result;
            }
            System.out.println("密码不正确");
            result.setData(false);
            return result;
        }


    }
}

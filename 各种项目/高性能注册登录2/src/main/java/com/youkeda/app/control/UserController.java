package com.youkeda.app.control;

import com.youkeda.app.dataobject.UserDO;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @return Result
     */
    @GetMapping("/registered")
    @ResponseBody
    public Result<Boolean> registered(UserDO userDO) {
        //初始化数据填写自己的信息

        return userService.add(userDO);

    }

    /**
     * 登录
     *
     * @return Result
     */
    @GetMapping("/login")
    @ResponseBody
    public Result<Boolean> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        //初始化数据

       return userService.login(email,password);

    }
}
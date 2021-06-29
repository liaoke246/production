package com.youkeda.app.control;

import com.youkeda.app.model.Result;
import com.youkeda.app.model.User;
import com.youkeda.app.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2020/6/6, 周六
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> addUser(@RequestBody User user) {

        Result<Integer> result = new Result<>();



        return result;

    }


}

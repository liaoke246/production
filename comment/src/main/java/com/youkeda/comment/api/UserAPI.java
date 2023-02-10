package com.youkeda.comment.api;

import com.alibaba.fastjson.JSONObject;
import com.youkeda.comment.model.Result;
import com.youkeda.comment.model.User;
import com.youkeda.comment.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joe
 */
@Controller
public class UserAPI {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model){

        return "index.html";
    }
    @RequestMapping("/login")
    public String login1(){

        return "login.html";
    }
    @RequestMapping("/login2")
    public String login2(){

        return "login2.html";
    }
    @RequestMapping("/register")
    public String reg1(){
    
        return "register.html";
    }
    @CrossOrigin(allowCredentials = "true")
    @PostMapping("/api/user/reg")
    @ResponseBody
    public Result<User> reg(@RequestBody JSONObject jsonObject,HttpServletResponse response) {
        String userName = jsonObject.getString("userName");
        String pwd = jsonObject.getString("pwd");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");


        return userService.register(userName, pwd);
    }


    @PostMapping("/api/user/login")
    @ResponseBody
    public Result<User> login(@RequestBody JSONObject jsonObject, HttpServletRequest request,HttpServletResponse response) {
        String userName = jsonObject.getString("userName");
        String pwd = jsonObject.getString("pwd");
        response.setHeader("Cache-Control","no-cache");
        User user = new User();
     
        Result<User> result = userService.login(userName, pwd);
      if(result.isSuccess()){
          HttpSession session = request.getSession();
          session.setAttribute("userId",result.getData().getId());
      }



        return result;
    }

    @GetMapping("/api/user/logout")
    public Result logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute("userId");
           Result result = new Result();

           result.setSuccess(true);


       return result;
    }


}

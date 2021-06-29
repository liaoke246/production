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

    @PostMapping("/api/user/reg")
    @ResponseBody
    public Result<User> reg(@RequestBody JSONObject jsonObject) {
        String userName = jsonObject.getString("userName");
        String pwd = jsonObject.getString("pwd");



        return userService.register(userName, pwd);
    }


@PostMapping("/api/user/superlogin")
    public String superLogin(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd, @RequestParam("key") String key, Model model,HttpServletRequest request){
  Result<User> result = userService.login(userName, pwd);

if(key.equals("kksk") && result.isSuccess()){
    request.getSession().setAttribute("userId", result.getData().getId());
    model.addAttribute("userName",userName);
    return "loginsuccess2";
}
return null;
}

    @PostMapping("/api/user/login")
    @ResponseBody
    public Map login(@RequestBody JSONObject jsonObject) {
        String userName = jsonObject.getString("userName");
        String pwd = jsonObject.getString("pwd");

        Result<User> result = userService.login(userName, pwd);
         String token = String.valueOf(result.getData().getId());

        Map returnData = new HashMap();

        returnData.put("data",result);
        returnData.put("token",token);
            if (result.isSuccess()) {
                stringRedisTemplate.opsForValue().set("token",token);
            return returnData;
        }

        return null;
    }

    @GetMapping("/api/user/logout")
    public String logout(String token) {
       if(token.equals(stringRedisTemplate.opsForValue().get("token"))) {
           Result result = new Result();
           stringRedisTemplate.delete("token");
           result.setSuccess(true);
           return "index";
       }
       return null;
    }


}

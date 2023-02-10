package com.youkeda.comment.api;


import com.alibaba.fastjson.JSONObject;
import com.youkeda.comment.model.Comment;
import com.youkeda.comment.model.Result;
import com.youkeda.comment.model.User;
import com.youkeda.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author joe
 */
@Controller
public class CommentAPI {



  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private CommentService commentService;



  @PostMapping("/api/comment/post")
  @ResponseBody
  public Result<Comment> post(@RequestBody JSONObject jsonObject, HttpServletRequest request,HttpServletResponse response) {

    String refId = jsonObject.getString("refId");
    Long parentId = Long.parseLong(jsonObject.getString("parentId"));
    String content = jsonObject.getString("content");

    response.setHeader("Cache-Control","no-cache");
    HttpSession session = request.getSession();
    long userId = (long)session.getAttribute("userId");


    return commentService.post(refId, userId, parentId, content);

  }



  @GetMapping("/api/comment/query")
  @ResponseBody
  public Map query(@RequestParam("refId") String refId,HttpServletResponse response) {

    Map returnMap = new HashMap();
    //调用服务层的query方法获取评论数据
    Result<List<Comment>> result = commentService.query(refId);

    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Cache-Control","no-cache");
    //将获取到的数据进行分析，组装
    List<Comment> comments = result.getData();

    for(Comment comment1 : comments){
      Map returnMap1 = new HashMap();
      User user = comment1.getAuthor();
      String name = user.getNickName();
      String id = String.valueOf(comment1.getId());
      String content = comment1.getContent();
      String avatar = user.getAvatar();

      String created = comment1.getGmtCreated().toString();
    //开始组装 姓名头像地址 内容 时间。
      returnMap1.put("name",name);
      returnMap1.put("avatar",avatar);
      returnMap1.put("content",content);
      returnMap1.put("created",created);
      returnMap.put("id"+id,returnMap1);
    }

    return returnMap;
  }
}




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


import java.util.*;

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
  public Result<Comment> post(@RequestBody JSONObject jsonObject) {

    String refId = jsonObject.getString("refId");
    String parentId2 = jsonObject.getString("parentId");
    String content = jsonObject.getString("content");

    Long parentId = Long.parseLong(parentId2);
    String token1 = jsonObject.getString("token");
  String token = stringRedisTemplate.opsForValue().get("token");

    Long userId = Long.parseLong(token);

    //long userId = (long) request.getSession().getAttribute("userId");
if(token.equals(token1)){
    return commentService.post(refId, userId, parentId, content);
  }

return null;
  }

  @GetMapping("/api/comment/query")
  @ResponseBody
  public Map query(@RequestParam("refId") String refId) {

    Map returnMap = new HashMap();
    Result<List<Comment>> result = commentService.query(refId);



    List<Comment> comments = result.getData();

    for(Comment comment1 : comments){
      Map returnMap1 = new HashMap();
      User user = comment1.getAuthor();
      String name = user.getNickName();
      String id = String.valueOf(comment1.getId());
      String content = comment1.getContent();

      String created = comment1.getGmtCreated().toString();

      returnMap1.put("name",name);
      returnMap1.put("content",content);
      returnMap1.put("created",created);
      returnMap.put("id"+id,returnMap1);
    }

    return returnMap;
  }
}




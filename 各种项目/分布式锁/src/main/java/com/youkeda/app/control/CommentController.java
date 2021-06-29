package com.youkeda.app.control;

import com.youkeda.app.dataobject.CommentDO;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @date 2020/6/16, 周二
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/add")
    public Result<Integer> add(@RequestBody CommentDO commentDO){

        Result<Integer> result = new Result<>();

        //初始化点赞数
        commentDO.setLikes(0L);

        result.setData(commentService.add(commentDO));
        result.setSuccess(true);

        return result;
    }

    @PostMapping("/addlike")
    @ResponseBody
    public Result<Integer> addLike(@RequestParam("commentId") String commentId){

        Result<Integer> result = new Result<>();

        result.setData(commentService.addLike(commentId));
        result.setSuccess(true);
        return result;
    }

}

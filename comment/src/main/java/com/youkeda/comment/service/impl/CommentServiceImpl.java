package com.youkeda.comment.service.impl;

import com.youkeda.comment.dao.CommentDAO;
import com.youkeda.comment.dataobject.CommentDO;
import com.youkeda.comment.model.Comment;
import com.youkeda.comment.model.Result;
import com.youkeda.comment.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Result<Comment> post(String refId, long userId, long parentId, String content) {
        Result<Comment> result = new Result<>();
        if (StringUtils.isEmpty(refId) || userId == 0 || StringUtils.isEmpty(content)) {
            result.setCode("500");
            result.setMessage("refId、userId、content 不能为空");
            return result;
        }

        String body = StringEscapeUtils.escapeHtml4(content);

        CommentDO commentDO = new CommentDO();
        commentDO.setUserId(userId);
        commentDO.setRefId(refId);
        commentDO.setParentId(parentId);
        commentDO.setContent(body);
        commentDAO.insert(commentDO);

        result.setData(commentDO.toModel());

        return result;
    }


    public Result<List<Comment>> query(String refId) {

        Result<List<Comment>> result = new Result<>();
        //查询所有的评论记录包含回复的
        List<Comment> comments = commentDAO.findByRefId(refId);
        //构建 map 结构
        Map<Long, Comment> commentMap = new HashMap<>();
        //初始化一个虚拟根节点，0 可以对应的是所有一级评论的父亲
        commentMap.put(0L, new Comment());
        //把所有的评论转换为 map 数据
        comments.forEach(comment -> commentMap.put(comment.getId(), comment));
        // 再次遍历评论数据
        comments.forEach(comment -> {
            //得到父评论
            Comment parent = commentMap.get(comment.getParentId());
            if(parent == null){
                comment.setParentId(0L);
            }
            //操作它的父亲,如果父亲不是空的话
            if (parent != null) {
                // 初始化 children 变量 ,儿子为空就创建 不为空就直接添加
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                // 在父评论里添加回复数据
                parent.getChildren().add(comment);
            }
        });
        // 得到所有的一级评论
        List<Comment> data = commentMap.get(0L).getChildren();

        result.setSuccess(true);
        result.setData(data);

        return result;
    }
}

package com.youkeda.app;

import com.youkeda.app.control.CommentController;
import com.youkeda.app.dao.CommentDAO;
import com.youkeda.app.dataobject.CommentDO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    private CommentController commentController;

    @Autowired
    private CommentDAO commentDAO;

    @Test
    void contextLoads() {
        CommentDO commentDO = new CommentDO();
        commentDO.setContent("测试内容");
        commentDO.setTitle("测试标题");
        commentController.add(commentDO);

        List<CommentDO> commentDOS = commentDAO.selectAll();

        Assertions.assertThat(commentDOS).isNotEqualTo(null);
        Assertions.assertThat(commentDOS.size()).isGreaterThan(0);

        commentController.addLike(commentDOS.get(0).getId());

        commentDOS = commentDAO.selectAll();
        Assertions.assertThat(commentDOS.get(0).getLikes()).isNotEqualTo(0);
    }
    

}

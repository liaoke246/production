package com.youkeda.app;

import com.youkeda.app.control.CommentController;
import com.youkeda.app.dataobject.CommentDO;
import com.youkeda.app.model.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private CommentController  commentController;

	@Test
	void contextLoads() {
		CommentDO commentDO = new CommentDO();
		commentDO.setLikes(1l);
		Result<Integer> result = commentController.add(commentDO);

		Assertions.assertThat(result.getData()).isEqualTo(1);
	}

}

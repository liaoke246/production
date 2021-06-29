package com.youkeda.app;

import com.youkeda.app.control.UserController;
import com.youkeda.app.dataobject.UserDO;
import com.youkeda.app.model.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class  AppApplicationTests{

	public static void error(String msg) {
		System.err.println("<YkdError>" + msg+"</YkdError>");
	}
	@Autowired
	private UserController userController;


	@Test
	public void runA() {
		UserDO userDO = new UserDO();
		userDO.setNickname("百云飘飘");
		userDO.setEmail("18513704432@163.com");
		userDO.setGender("男");

		Result<Boolean> registered = userController.registered(userDO);
		if(registered.getData()){
			error("没有校验密码是否必填");
			return;
		}
		UserDO userDO1 = new UserDO();
		userDO1.setNickname("百云飘飘");
		userDO1.setPassword("666666");
		userDO1.setGender("男");

		Result<Boolean> registered1=userController.registered(userDO1);
		if(registered1.getData()){
			error("没有校验邮箱是否必填");
			return;
		}
		UserDO userDO2 = new UserDO();
		userDO2.setNickname("百云飘飘");
		userDO2.setPassword("666666");
		userDO2.setEmail("18513704432@163.com");
		userDO2.setGender("男");

		userController.registered(userDO2);

		UserDO userDO3 = new UserDO();
		userDO3.setNickname("百云飘飘");
		userDO3.setPassword("666666");
		userDO3.setEmail("18513704432@163.com");
		userDO3.setGender("男");

		Result<Boolean> registered2=userController.registered(userDO3);
		if(registered2.getData()){
			error("没有校验该邮箱是否注册");
		}
	}



}

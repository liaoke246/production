package com.youkeda.app;

import com.youkeda.app.control.UserController;
import com.youkeda.app.model.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppApplicationTests {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Autowired
    private UserController userController;

    @Test
    public void runA() {
        Result<Boolean> login = userController.login("18513704432@163.com", "666666");
        if (login != null) {
            if (login.getData()) {
                error("没有校验邮箱是否注册，或者密码是否匹配");
                return;
            }

        }
    }

}

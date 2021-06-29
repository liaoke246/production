package com.youkeda.app;

import com.youkeda.app.control.SnappedUpController;
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
    private SnappedUpController snappedUpController;

    @Test
    public void runA() {
        boolean result = true;
        for (int i = 0; i < 10; i++) {
            Result<Boolean> booleanResult = snappedUpController.snappedUp(1l);
            if (!booleanResult.getData()) {
                result = false;
            }
        }
        if (result) {
            error("没有按照要求写代码，没有判断商品库存数量");
        }

    }

}

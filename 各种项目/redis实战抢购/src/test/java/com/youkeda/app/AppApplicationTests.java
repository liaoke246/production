package com.youkeda.app;

import com.youkeda.app.model.Result;
import com.youkeda.app.service.TicketPurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@SpringBootTest
public class AppApplicationTests {
    @Autowired
    private TicketPurchaseService ticketPurchaseService;
    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runA() {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.app.dataobject.VotesDO");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.app.dataobject.VotesDO`类");
            return;
        }

        try {
            Field field = aClass.getDeclaredField("price");
            if (!field.getType().equals(double.class)) {
                error("`VotesDO`类的 price 属性不是 double 类型");
                return;
            }
            if (!Modifier.isPrivate(field.getModifiers())) {
                error("`VotesDO`类的 price 属性不是 private");
                return;
            }
        } catch (NoSuchFieldException e) {
            error("`VotesDO`类没有创建 price 属性");
            return;
        }
        try {
            Field field = aClass.getDeclaredField("id");
            if (!field.getType().equals(Long.class)) {
                error("`VotesDO`类的 price 属性不是 Long 类型");
                return;
            }
        } catch (NoSuchFieldException e) {
            error("`VotesDO` 类没有创建 id 属性");
            return;
        }
        try {
            Field field = aClass.getDeclaredField("name");
            if (!field.getType().equals(String.class)) {
                error("`VotesDO`类的 name 属性不是 String 类型");
                return;
            }
        } catch (NoSuchFieldException e) {
            error("`VotesDO` 类没有创建 name 属性");
            return;
        }
        try {
            Field field = aClass.getDeclaredField("stock");
            if (!field.getType().equals(int.class)) {
                error("`VotesDO`类的 stock 属性不是 int 类型");
                return;
            }
        } catch (NoSuchFieldException e) {
            error("`VotesDO` 类没有创建 stock 属性");
            return;
        }
        //判断有没有按照要求实现代码
        for (int i = 0; i < 13; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Result<Boolean> ticketpurchase = ticketPurchaseService.ticketPurchase(1);
                }
            }).start();

        }
    }

}

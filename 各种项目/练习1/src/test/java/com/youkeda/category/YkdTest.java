package com.youkeda.category;

import com.youkeda.category.control.CategoryApi;
import com.youkeda.category.model.Category;
import com.youkeda.category.model.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YkdTest {
    @Autowired
    private CategoryApi categoryApi;

    @Test
    void contextLoads() {

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.category.control.CategoryApi");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.category.control.CategoryApi`类");
            return;
        }

        try {
            aClass = Class.forName("com.youkeda.category.model.Category");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.category.model.Category`类");
            return;
        }

        Category category = new Category();
        category.setId("00001");
        category.setDescription("测试");
        category.setName("分类1");
        category.setParentCategoryId("000012");
        Result<Category> result = categoryApi.add(category);
        if (!result.getSuccess() || result.getData() == null) {
            error("插入类目失败");
        }
    }

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }
}

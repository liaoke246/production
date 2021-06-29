package com.youkeda.app.service;

import com.youkeda.app.model.User;

import java.util.List;

/**
 * 用户service
 *
 * @date 2020/6/6, 周六
 */
public interface UserService {

    /**
     * 添加或者修改用户
     *
     * @param user 个人战绩
     * @return User
     */
    Integer save(User user);


}

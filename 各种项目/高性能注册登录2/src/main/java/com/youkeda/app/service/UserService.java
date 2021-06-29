package com.youkeda.app.service;

import com.youkeda.app.dataobject.UserDO;
import com.youkeda.app.model.Result;

/**
 * @Author jiaoheng
 * @DATE 2020-06-08
 */
public interface UserService {
    /**
     * 注册
     */
    Result<Boolean> add(UserDO userDO);
    Result<Boolean> login(String email, String password);
}

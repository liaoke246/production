package com.youkeda.app.dao;

import com.youkeda.app.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    int insert(UserDO userDO);
    UserDO selectByEmail(String email);
}

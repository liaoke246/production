package com.youkeda.app.service.impl;

import com.youkeda.app.dao.UserDAO;
import com.youkeda.app.model.User;
import com.youkeda.app.service.PersonalRecordService;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 2020/6/6, 周六
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PersonalRecordService personalRecordService;

    @Override
    public Integer save(User user) {


        return 0;
    }

}

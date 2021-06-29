package com.youkeda.app.service.impl;

import com.youkeda.app.dao.PersonalRecordDAO;
import com.youkeda.app.model.PersonalRecord;
import com.youkeda.app.service.PersonalRecordService;
import com.youkeda.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 2020/6/6, 周六
 */
@Service
public class PersonalRecordServiceImpl implements PersonalRecordService {

    @Autowired
    private PersonalRecordDAO personalRecordDAO;

    @Autowired
    private UserService userService;

    @Override
    public int save(PersonalRecord personalRecord) {

        return 0;

    }

}

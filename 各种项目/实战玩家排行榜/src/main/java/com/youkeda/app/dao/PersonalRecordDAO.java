package com.youkeda.app.dao;

import com.youkeda.app.dataobject.PersonalRecordDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalRecordDAO {

    int deleteByUserId(Long userId);

    int insert(PersonalRecordDO record);

    PersonalRecordDO selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PersonalRecordDO record);

}
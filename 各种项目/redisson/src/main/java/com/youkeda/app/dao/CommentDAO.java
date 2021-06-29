package com.youkeda.app.dao;

import com.youkeda.app.dataobject.CommentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    int deleteByPrimaryKey(String id);

    int insert(CommentDO record);

    CommentDO selectByPrimaryKey(String id);

    List<CommentDO> selectAll();

    int updateByPrimaryKey(CommentDO record);
}
package com.youkeda.app.dao;

import com.youkeda.app.dataobject.VotesDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VotesDAO {
    int insert(VotesDO votesDO);

    VotesDO selectById(long id);
    
    int updateStock(VotesDO votesDO);
}

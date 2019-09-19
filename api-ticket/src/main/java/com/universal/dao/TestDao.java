package com.universal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TestDao {

    @Update("UPDATE lcn_test SET num = num - 1 WHERE id = 1 ")
    int updateTicket();
}

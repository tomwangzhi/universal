package com.universal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestDao {

    @Insert("INSERT INTO lcn_test(info) VALUES(#{info}) ")
    int save(@Param("info") String info);
}

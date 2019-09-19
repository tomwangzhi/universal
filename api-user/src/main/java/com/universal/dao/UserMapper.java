package com.universal.dao;

import com.universal.model.user.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author YIJIUE
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM app_user WHERE username = #{username}")
    AppUser getUser(@Param("username")String username);
}

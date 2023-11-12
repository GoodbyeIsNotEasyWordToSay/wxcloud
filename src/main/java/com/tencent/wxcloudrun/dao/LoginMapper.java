package com.tencent.wxcloudrun.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    @Select("select UID from user where openID = #{openID}")
    Integer getUID(@Param("openID") String openID);

    @Insert("insert into user (Urole,openID) values (0,#{openID})")
    void insertUser(@Param("openID") String openID);
}

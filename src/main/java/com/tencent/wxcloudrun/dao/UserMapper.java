package com.tencent.wxcloudrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select Uname from user where UID= #{uid}")
    String getUserName(@Param("uid") String uid);

    @Select("select i_url from user_image where u_id= #{uid}")
    String getUserProfilePhoto(@Param("uid") String uid);
}

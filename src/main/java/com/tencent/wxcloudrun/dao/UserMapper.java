package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.model.UserImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select UID from user where UID = #{uid}")
    String getUID(@Param("uid") String openid);

    @Insert("insert into user (UID, Urole, Uname) values (#{uid}, #{role}, #{name})")
    void createUser(User user);

    @Insert("insert into user_image (u_id, i_url, i_category) values (#{u_id}, #{i_url}, #{i_category})")
    void insertUserProfilePhoto(UserImage userImage);
}

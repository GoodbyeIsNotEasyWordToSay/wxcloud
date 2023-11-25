package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM ( SELECT * FROM message WHERE Mtime IN ( SELECT MAX( Mtime ) FROM message WHERE ReceiverID = #{uid} OR SenderID = #{uid} GROUP BY CONCAT( IF ( SenderID > ReceiverID, SenderID, ReceiverID ), IF ( SenderID < ReceiverID, SenderID, ReceiverID ))) AND ( ReceiverID = #{uid} OR SenderID = #{uid} ) ORDER BY MID DESC ) c ORDER BY Mtime DESC")
    ArrayList<Message> getMessageList(@Param("uid") String uid);
}


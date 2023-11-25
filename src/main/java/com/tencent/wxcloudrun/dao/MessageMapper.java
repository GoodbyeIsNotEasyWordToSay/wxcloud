package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.MessageRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Mapper
public interface MessageMapper {
    @Select("select * from message where SenderID = #{senderid} and ReceiverID = #{receiverid}")
    ArrayList<MessageRequest>getMessage(@Param("senderid") String senderid,@Param("receiverid") String receiverid);

    @Insert("insert into message (SenderID,ReceiverID,Content,Mtime) values(#{senderid},#{receiverid},#{content},#{mtime})")
    void insertMessage(@Param("senderid")String senderid, @Param("receiverid")String receiverid, @Param("content")String content, @Param("mtime")LocalDateTime mtime);
}

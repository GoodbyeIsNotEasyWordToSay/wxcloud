package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.OperationLog;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;


@Mapper
public interface OperationMapper {

    @Select("select OID from operation where GID = #{gid} and UserID = #{userid}" )
    Integer selectOID(@Param("gid") int gid, @Param("userid") String userid);

    @Update("UPDATE operation SET Otime = #{otime} WHERE OID = #{OID} and Otype = 0")
    void updateOtime(@Param("otime")LocalDateTime otime, @Param("OID") Integer oID);

    @Insert("insert into operation (GID,UserID,Otype,Otime) values (#{gid},#{userid},#{otype},#{otime})")
    void InsertOperation(@Param("gid") int gid, @Param("userid") String userid,@Param("otype") int otype,@Param("otime")LocalDateTime otime);

    @Delete("delete from operation where OID = #{OID} and Otype IN (1, 2)")
    void DeleteOperation(@Param("OID") Integer oID);
}

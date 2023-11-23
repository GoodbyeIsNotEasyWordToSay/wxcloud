package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.OperationLog;
import org.apache.ibatis.annotations.*;


@Mapper
public interface OperationMapper {
    @Update("UPDATE your_table_name SET Otime = #{operationLog.getotime()} WHERE OID = #{oID} and Otype = 0}")
    void updateOtime(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);

    @Select("select OID from operation where GID = #{operationLog.getgid()} and UserID = #{operationLog.getuserid()}" )
    Integer selectOID(@Param("operationLog") OperationLog operationLog);

    @Insert("insert into operation (GID,UserID,Otype,Otime) values (#{operationLog.getgid()},#{operationLog.getuserid()},#{operationLog.getotype()},#{operationLog.getotime()})")
    void InsertOperation(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);

    @Delete("delete * from operation where OID = #{oID} and Otype IN (1, 2)")
    void DeleteOperation(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);
}

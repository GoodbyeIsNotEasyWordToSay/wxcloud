package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.OperationLog;
import org.apache.ibatis.annotations.*;


@Mapper
public interface OperationMapper {
    @Update("UPDATE your_table_name SET Otime = #{operation.getOtime()} WHERE OID = #{oID} and Otype = 0}")
    void updateOtime(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);

    @Select("select OID from operation where GID = #{operationLog.getGID()} and UserID = #{operationLog.getUserID()}" )
    Integer selectOID(@Param("operationLog") OperationLog operationLog);

    @Insert("insert into operation (GID,UserID,Otype,Otime) values (#{operationLog.getGID()},#{operationLog.getUserID()},#{operationLog.getOtype()},#{operationLog.getOtime()})")
    void InsertOperation(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);

    @Delete("delete * from operation where OID = #{oID} and Otype IN (1, 2)")
    void DeleteOperation(@Param("operationLog") OperationLog operationLog, @Param("OID") Integer oID);
}

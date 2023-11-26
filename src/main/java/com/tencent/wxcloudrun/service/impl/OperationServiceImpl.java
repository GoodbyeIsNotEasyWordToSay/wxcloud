package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.OperationMapper;
import com.tencent.wxcloudrun.dto.OperationLog;
import com.tencent.wxcloudrun.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationMapper operationMapper;

    public OperationServiceImpl(@Autowired OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }

    public int Operation(OperationLog operationLog){

        int gid = operationLog.getGid();
        String userid = operationLog.getUserid();
        int otype = operationLog.getOtype();
        LocalDateTime otime = operationLog.getOtime();

        Integer oid = operationMapper.selectOID(gid,userid);
        if(oid == null){
            operationMapper.InsertOperation(gid,userid,otype,otime);
        }
        else {
            operationMapper.updateOtime(otime, oid);
            operationMapper.DeleteOperation(oid);
        }

        return 1;
    }

    @Override
    public int wannaBuy(String uid, Integer gid) {
        operationMapper.InsertNewOperation(gid,uid,2);
        return 1;
    }
}

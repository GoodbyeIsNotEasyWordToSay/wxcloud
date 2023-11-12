package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.OperationMapper;
import com.tencent.wxcloudrun.dto.OperationLog;
import com.tencent.wxcloudrun.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationMapper operationMapper;

    public OperationServiceImpl(@Autowired OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }

    public int Operation(OperationLog operationLog){
        Integer oid = operationMapper.selectOID(operationLog);

        if(oid == null){
            operationMapper.InsertOperation(operationLog, oid);
        }
        else {
            operationMapper.updateOtime(operationLog, oid);
            operationMapper.DeleteOperation(operationLog, oid);
        }

        return 1;
    }
}

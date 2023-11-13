package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.OperationLog;

public interface OperationService {
    int Operation(OperationLog operationLog);
}

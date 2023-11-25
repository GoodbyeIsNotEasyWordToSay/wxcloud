package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Deal;
import com.tencent.wxcloudrun.model.Operation;
import com.tencent.wxcloudrun.service.OperationService;
import com.tencent.wxcloudrun.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PersonalController {

    @Resource
    private  PersonalService personalService;

    @Resource
    private OperationService operationService;

    public PersonalController(@Autowired PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/api/personal/queryCollectByUid")
    public ApiResponse queryCollectByUid(@RequestHeader("x-wx-openid") String uid){
        List<Operation>  list = operationService.queryCollectByUid(uid);
        return ApiResponse.ok(list);
    }

    @GetMapping("/api/personal/queryBuyByUid")
    public ApiResponse queryBuyByUid(@RequestHeader("x-wx-openid") String uid){
        List<Deal> list =  personalService.buyOrSell(uid, null);
        return ApiResponse.ok(list);
    }

    @GetMapping("/api/personal/querySellByUid")
    public ApiResponse querySellByUid(@RequestHeader("x-wx-openid") String uid){
        List<Deal> list =  personalService.buyOrSell(null, uid);
        return ApiResponse.ok(list);
    }
}

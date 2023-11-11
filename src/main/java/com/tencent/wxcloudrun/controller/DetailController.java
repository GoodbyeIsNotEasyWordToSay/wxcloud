package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.DetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@RestController
public class DetailController {

    final DetailService detailService;

    public DetailController(@Autowired DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/api/goods/{gid}")
    public ApiResponse getDetails(int gid) {
        Optional<Goods> Details = detailService.getDetails(gid);
        if (Details != null) {
            return ApiResponse.ok(Details); // 如果成功获取到商品详情，则返回成功的响应
        } else {
            return ApiResponse.error("Product details not found for GID: " + gid); // 商品详情未找到的错误响应
        }
    }
}
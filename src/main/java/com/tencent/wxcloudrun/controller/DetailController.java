package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.DetailService;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DetailController {

    final DetailService detailService;

    public DetailController(@Autowired DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/api/goods/{gid}")
    public ApiResponse getDetails(@PathVariable Integer gid) {
        Optional<Goods> details = detailService.getGoodsDetail(gid);
        if (details.isPresent()) {
            return ApiResponse.ok(details); // 如果成功获取到商品详情，则返回成功的响应
        } else {
            return ApiResponse.error("Product details not found for GID: " + gid); // 商品详情未找到的错误响应
        }
    }
}
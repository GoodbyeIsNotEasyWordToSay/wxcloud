package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.dto.ReleaseRequest;
import com.tencent.wxcloudrun.model.Errand;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.model.IdleItem;
import com.tencent.wxcloudrun.service.GoodsService;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GoodsController {

    final GoodsService goodsService;
    final Logger logger;

    public GoodsController(@Autowired GoodsService goodsService) {
        this.goodsService = goodsService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    @GetMapping("/api/goods/{gid}")
    public ApiResponse getDetails(@PathVariable Integer gid) {
        Optional<Good> details = goodsService.getGoodsDetail(gid);
        if (details.isPresent()) {
            return ApiResponse.ok(details); // 如果成功获取到商品详情，则返回成功的响应
        } else {
            return ApiResponse.error("Product details not found for GID: " + gid); // 商品详情未找到的错误响应
        }
    }

    @PostMapping("/api/goods/release")
    ApiResponse create(@RequestBody ReleaseRequest request){
        logger.info("/api/goods/release POST request");
        logger.info(request.toString());
        logger.info("request.uID =" + request.getUID());
        if(request.getCategory() == 0){
            IdleItem idleItem = new IdleItem();
            idleItem.setGdes(request.getDescription());
            idleItem.setGprice(request.getPrice());
            idleItem.setGcampus(request.getCampus());
            idleItem.setGoodsImageList(request.getImageList());
            idleItem.setGcategory(0);
            idleItem.setStatus(1);
            idleItem.setUID(request.getUID());

            int insertResult = goodsService.insertIdleItem(idleItem);
            if(insertResult == 1){
                return ApiResponse.ok("成功发布");
            }
            else {
                return ApiResponse.error("发布失败");
            }
        }
        else {
            Errand errand = new Errand();
            errand.setGdes(request.getDescription());
            errand.setGprice(request.getPrice());
            errand.setGcampus(request.getCampus());
            errand.setGoodsImageList(request.getImageList());
            errand.setGcategory(1);
            errand.setStatus(1);
            errand.setUID(request.getUID());
            errand.setDeadline(request.getDeadline());

            int insertResult = goodsService.insertErrand(errand);
            if(insertResult == 1){
                return ApiResponse.ok("成功发布");
            }
            else {
                return ApiResponse.error("发布失败");
            }
        }
    }
}
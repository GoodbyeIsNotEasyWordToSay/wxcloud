package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.service.HomeService;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class HomeController {
    final HomeService homeService;
    public HomeController(@Autowired HomeService homeService){this.homeService=homeService;}

    @GetMapping("/api/home/{Gcategory}")
    public ApiResponse getHome(@PathVariable Integer Gcategory) {
        Optional<ArrayList<Good>> Home = homeService.getSellingGoods(Gcategory);
        if (Home.isPresent()) {
            return ApiResponse.ok(Home);
        } else {
            return ApiResponse.error("");
        }
    }
}

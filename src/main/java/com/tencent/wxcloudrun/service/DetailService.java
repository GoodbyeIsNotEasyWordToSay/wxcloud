package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Goods;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface DetailService {
    Optional<Goods> getGoodsDetail(Integer gid);
}

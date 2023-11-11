package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Goods;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DetailService {
    Optional<Goods> getDetails(int gid);
}

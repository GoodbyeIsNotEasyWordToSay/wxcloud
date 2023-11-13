package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Good;

import java.util.ArrayList;
import java.util.Optional;

public interface HomeService {
    Optional<ArrayList<Good>> getSellingGoods(Integer Gcategory);
}

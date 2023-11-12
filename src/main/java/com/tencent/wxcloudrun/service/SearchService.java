package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Good;

import java.util.ArrayList;
import java.util.Optional;

public interface SearchService {
    Optional<ArrayList<Good>> searchGoods(String keyword);
}
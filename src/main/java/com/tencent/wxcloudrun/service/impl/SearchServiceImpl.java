package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Optional<ArrayList<Good>> searchGoods(String keyword) {
        return Optional.ofNullable(goodsMapper.getGoods(keyword));
    }
}

package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {

    final GoodsMapper goodsMapper;

    public DetailServiceImpl(@Autowired GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public Optional<Goods> getGoodsDetail(int gid) {
        return Optional.ofNullable(goodsMapper.getGoods(gid));
    }
}

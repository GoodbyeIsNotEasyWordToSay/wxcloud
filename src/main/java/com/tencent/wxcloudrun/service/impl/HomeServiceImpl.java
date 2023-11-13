package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {
    final GoodsMapper goodsMapper;

    public HomeServiceImpl(@Autowired GoodsMapper goodsMapper){this.goodsMapper=goodsMapper;}
    @Override
    public Optional<ArrayList<Good>> getSellingGoods(Integer Gcategory){
        ArrayList<Good> goods;
        goods=goodsMapper.getSellingGoods(Gcategory);
        goods.forEach((e)->{
            e.setGoodsImageList(goodsMapper.getGoodImage(e.getGID()));
        });
        return Optional.of(goods);
    }
}

package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.dao.ImageMapper;
import com.tencent.wxcloudrun.model.Errand;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.model.GoodsImage;
import com.tencent.wxcloudrun.model.IdleItem;
import com.tencent.wxcloudrun.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    final GoodsMapper goodsMapper;
    final ImageMapper imageMapper;

    public GoodsServiceImpl(@Autowired GoodsMapper goodsMapper, @Autowired ImageMapper imageMapper) {
        this.goodsMapper = goodsMapper;
        this.imageMapper = imageMapper;
    }

    @Override
    public Optional<Good> getGoodsDetail(Integer gid) {
        Good good = goodsMapper.getGood(gid);
        good.setGoodsImageList(goodsMapper.getGoodImage(gid));
        return Optional.of(good);
    }

    @Override
    public int insertIdleItem(IdleItem idleItem) {
        try {
            goodsMapper.insertGood(idleItem);
            goodsMapper.insertIdleItem(idleItem);
            Integer gid = idleItem.getGID();
            ArrayList<GoodsImage> goodsImages = idleItem.getGoodsImageList();
            for (GoodsImage x:
                 goodsImages) {
                x.setG_id(gid);
                imageMapper.insertGoodImage(x);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    @Override
    public int insertErrand(Errand errand) {
        try{
            goodsMapper.insertGood(errand);
            goodsMapper.insertErrand(errand);
            Integer gid = errand.getGID();
            ArrayList<GoodsImage> goodsImages = errand.getGoodsImageList();
            for (GoodsImage x:
                    goodsImages) {
                x.setG_id(gid);
                imageMapper.insertGoodImage(x);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

}

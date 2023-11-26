package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.dao.ImageMapper;
import com.tencent.wxcloudrun.model.Errand;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.model.GoodsImage;
import com.tencent.wxcloudrun.model.IdleItem;
import com.tencent.wxcloudrun.service.GoodsService;
import com.tencent.wxcloudrun.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    final GoodsMapper goodsMapper;
    final ImageMapper imageMapper;
    final ImageService imageService;

    public GoodsServiceImpl(@Autowired GoodsMapper goodsMapper, @Autowired ImageMapper imageMapper, @Autowired ImageService imageService) {
        this.goodsMapper = goodsMapper;
        this.imageMapper = imageMapper;
        this.imageService = imageService;
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
            for (GoodsImage x :
                    goodsImages) {
                x.setG_id(gid);
                imageMapper.insertGoodImage(x);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return idleItem.getGID();
    }

    @Override
    public int insertErrand(Errand errand) {
        try {
            goodsMapper.insertGood(errand);
            goodsMapper.insertErrand(errand);
            Integer gid = errand.getGID();
            ArrayList<GoodsImage> goodsImages = errand.getGoodsImageList();
            for (GoodsImage x :
                    goodsImages) {
                x.setG_id(gid);
                imageMapper.insertGoodImage(x);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return errand.getGID();
    }

    @Override
    public Optional<ArrayList<Good>> getSomeonesSellingGoods(String uid) {
        ArrayList<Good> goods=goodsMapper.getSomeonesSellingGoods(uid);
        goods.forEach((e)->{
            e.setGoodsImageList(goodsMapper.getFirstImage(e.getGID()));
        });
        return Optional.of(goods);
    }

    @Override
    public void modifyGood(Good good) {
        try {
            goodsMapper.modifyGood(good);
            if (good.getGcategory() == 0) {
                System.out.println("idle item 表不含待修改项");
            } else {
                goodsMapper.modifyErrand((Errand) good);
            }

            ArrayList<GoodsImage> originalGoodImages = goodsMapper.getGoodImage(good.getGID());
            if (!imageService.imageListsAreSame(originalGoodImages, good.getGoodsImageList())) {
                for (GoodsImage x : originalGoodImages) {
                    imageMapper.deleteGoodImage(x.getG_image_id());
                }
                for (GoodsImage y :
                        good.getGoodsImageList()) {
                    imageMapper.insertGoodImage(y);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int setGoodSold(int gid) {
        goodsMapper.setGoodSold(gid);
        return 1;
    }
}

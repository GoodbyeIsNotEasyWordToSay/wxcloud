package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.GoodsImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    @Insert("insert into goods_image (GID, IURL, IOrder) values (#{GID}, #{IURL}, #{IOrder})")
    public void insertGoodImage(GoodsImage x);
}

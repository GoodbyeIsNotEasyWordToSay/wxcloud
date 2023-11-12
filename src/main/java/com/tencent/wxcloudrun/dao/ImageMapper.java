package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.GoodsImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    @Insert("insert into goods_image (g_id, i_url, i_order) values (#{g_id}, #{i_url}, #{i_order})")
    public void insertGoodImage(GoodsImage x);
}

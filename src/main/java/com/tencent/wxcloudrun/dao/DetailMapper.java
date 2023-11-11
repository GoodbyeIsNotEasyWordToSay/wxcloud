package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DetailMapper {
    Goods getDetail(@Param("GID") int gid);
}

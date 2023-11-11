package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DetailMapper;
import com.tencent.wxcloudrun.model.Goods;
import com.tencent.wxcloudrun.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailServiceImpl {

    final DetailMapper detailMapper;

    public DetailServiceImpl(@Autowired DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    Optional<Goods> getDetails(int gid){
        return Optional.ofNullable(detailMapper.getDetail(gid));
    }

}

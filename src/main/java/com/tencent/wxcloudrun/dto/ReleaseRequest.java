package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.GoodsImage;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class ReleaseRequest implements Serializable {
    private String description;
    private Float price;
    private ArrayList<GoodsImage> imageList; //图片
    private Integer campus; //8-兴庆，4-雁塔，2-曲江，1-创新港；四个数字之和
    private Integer category; //0-闲置，1-跑腿
    private Integer status;
    private LocalDateTime deadline;

    public ReleaseRequest(){

    }
}

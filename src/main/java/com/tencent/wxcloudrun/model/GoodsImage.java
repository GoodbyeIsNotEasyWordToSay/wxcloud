package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsImage implements Serializable {
    protected Integer GImageID;
    protected Integer GID;
    protected String IURL;
    protected Integer IOrder;
}

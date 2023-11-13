package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsImage implements Serializable {
    protected Integer g_image_id;
    protected Integer g_id;
    protected String i_url;
    protected Integer i_order;
}

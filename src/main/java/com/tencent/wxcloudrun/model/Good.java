package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Good implements Serializable{
    protected Integer GID;

    protected String Gdes;

    protected Integer Gcampus;

    protected LocalDateTime Gcreatetime;

    protected LocalDateTime Gupdatetime;

    protected Integer Status;

    protected Integer Gcategory;

    protected String UID;

    protected Float Gprice;

    protected ArrayList<GoodsImage> goodsImageList;

}

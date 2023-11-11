package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Goods implements Serializable{
    private int GID;

    private String description;

    private int campus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private int status;

    private int category;

    private String UID;

    private float price;
}

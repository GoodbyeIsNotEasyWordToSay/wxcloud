package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Goods implements Serializable{
    private Integer GID;

    private String Gdes;

    private Integer Gcampus;

    private LocalDateTime Gcreatetime;

    private LocalDateTime Gupdatetime;

    private Integer Status;

    private Integer Gcategory;

    private Integer UID;

    private Float Gprice;
}

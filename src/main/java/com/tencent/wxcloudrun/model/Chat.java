package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Chat implements Serializable {
    protected Message message;
    protected String nameOfCounterpart;
    protected String profilePhoto;
}

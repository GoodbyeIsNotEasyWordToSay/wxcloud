package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OperationLog implements Serializable {
    private int gid;

    private String userid;

    private int otype;

    private LocalDateTime otime;


}

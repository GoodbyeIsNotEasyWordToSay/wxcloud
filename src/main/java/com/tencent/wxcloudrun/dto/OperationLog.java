package com.tencent.wxcloudrun.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OperationLog {
    private int gid;

    private int userid;

    private int otype;

    private LocalDateTime otime;

    public int getgid() {
        return gid;
    }

    public int getuserid() {
        return userid;
    }

    public int getotype() {
        return otype;
    }

    public LocalDateTime getotime() {
        return otime;
    }
}

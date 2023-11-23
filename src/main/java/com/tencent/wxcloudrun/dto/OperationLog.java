package com.tencent.wxcloudrun.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OperationLog {
    private int gid;

    private int userid;

    private int otype;

    private LocalDateTime otime;
}

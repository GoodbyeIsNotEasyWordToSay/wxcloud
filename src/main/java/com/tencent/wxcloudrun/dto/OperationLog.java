package com.tencent.wxcloudrun.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OperationLog {
    private int GID;

    private int UserID;

    private int Otype;

    private LocalDateTime Otime;
}

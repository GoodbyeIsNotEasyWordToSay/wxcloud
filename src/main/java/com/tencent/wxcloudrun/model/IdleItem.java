package com.tencent.wxcloudrun.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class IdleItem extends Good {
    private LocalDateTime endtime;
}

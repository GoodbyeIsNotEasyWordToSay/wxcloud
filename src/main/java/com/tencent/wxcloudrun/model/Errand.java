package com.tencent.wxcloudrun.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Errand extends Good implements Serializable {
    protected LocalDateTime deadline;
    protected LocalDateTime endtime;
}

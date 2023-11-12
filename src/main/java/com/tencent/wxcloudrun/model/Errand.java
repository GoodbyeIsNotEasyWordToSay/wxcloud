package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Errand extends Good implements Serializable {
    protected LocalDateTime deadline;
    protected LocalDateTime endtime;
}

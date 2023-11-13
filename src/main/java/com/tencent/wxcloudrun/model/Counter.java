package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Counter implements Serializable {

  protected Integer id;

  protected Integer count;

  protected LocalDateTime createdAt;

  protected LocalDateTime updatedAt;
}

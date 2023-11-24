package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchRequest implements Serializable {
    private String keyword;
}

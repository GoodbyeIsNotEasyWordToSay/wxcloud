package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class MessageRequest implements Serializable {
    int mid;
    String senderid;
    String receiverid;
    String content;
    LocalDateTime mtime;

}

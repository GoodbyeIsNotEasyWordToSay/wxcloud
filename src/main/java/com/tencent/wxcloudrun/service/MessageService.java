package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.MessageRequest;

import java.util.ArrayList;
import java.util.Optional;

public interface MessageService {
    Optional<ArrayList<MessageRequest>> getMessage(String senderid,String receiverid);

    int insertMessage(MessageRequest message);
}

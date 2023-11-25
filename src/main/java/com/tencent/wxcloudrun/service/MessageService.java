package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.model.Message;

import java.util.ArrayList;
import java.util.Optional;

public interface MessageService {
    Optional<ArrayList<MessageRequest>> getMessage(int userid);
    Optional<ArrayList<Message>> getMessageList(String uid);
}

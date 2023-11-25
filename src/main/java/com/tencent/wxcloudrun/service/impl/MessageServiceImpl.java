package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MessageMapper;
import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    final MessageMapper messageMapper;
    public MessageServiceImpl(@Autowired MessageMapper messageMapper){
        this.messageMapper=messageMapper;
    }
    @Override
    public Optional<ArrayList<MessageRequest>> getMessage(int userid) {
        return Optional.empty();
    }

    @Override
    public Optional<ArrayList<Message>> getMessageList(String uid) {
        ArrayList<Message> messages;
        messages=messageMapper.getMessageList(uid);
        return Optional.of(messages);
    }
}

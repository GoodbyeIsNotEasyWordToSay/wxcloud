package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MessageMapper;
import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    final MessageMapper messageMapper;
    public MessageServiceImpl(@Autowired MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }
    @Override
    public Optional<ArrayList<MessageRequest>> getMessage(String senderid,String receiverid) {
        ArrayList<MessageRequest> message = messageMapper.getMessage(senderid,receiverid);
        return Optional.of(message);
    }
    @Override
    public int insertMessage(MessageRequest message){
        String senderid = message.getSenderid();
        String reveiverid = message.getReceiverid();
        String content = message.getContent();
        LocalDateTime otime = message.getMtime();
        messageMapper.insertMessage(senderid,reveiverid,content,otime);
        return 0;
    }
}

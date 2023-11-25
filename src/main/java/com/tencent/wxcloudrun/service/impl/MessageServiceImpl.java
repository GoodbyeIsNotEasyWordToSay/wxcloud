package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MessageMapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.model.Chat;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MessageServiceImpl implements MessageService {
    final MessageMapper messageMapper;
    final UserMapper userMapper;

    public MessageServiceImpl(@Autowired MessageMapper messageMapper,UserMapper userMapper){
        this.messageMapper=messageMapper;
        this.userMapper=userMapper;
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

    @Override
    public Optional<ArrayList<Chat>> getMessageList(String uid) {
        ArrayList<Message> messages;
        ArrayList<Chat> chats=new ArrayList<>();
        AtomicInteger i= new AtomicInteger();
        messages=messageMapper.getMessageList(uid);
        messages.forEach((message) -> {
            if (message.getSenderid().equals(uid)){
                chats.get(i.get()).setMessage(message);
                chats.get(i.get()).setProfilePhoto(userMapper.getUserProfilePhoto(message.getReceiverid()));
                chats.get(i.get()).setNameOfCounterpart(userMapper.getUserName(message.getReceiverid()));
                i.getAndIncrement();
            }else {
                chats.get(i.get()).setMessage(message);
                chats.get(i.get()).setProfilePhoto(userMapper.getUserProfilePhoto(message.getSenderid()));
                chats.get(i.get()).setNameOfCounterpart(userMapper.getUserName(message.getSenderid()));
                i.getAndIncrement();
            }
        });
        return Optional.of(chats);
    }
}

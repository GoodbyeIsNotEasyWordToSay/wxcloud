package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.service.MessageService;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MessageController {
    final MessageService messageService;
    public MessageController(@Autowired MessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping ("/api/message/list/{uid}")
    public ApiResponse getMessageList(@PathVariable String uid){
        Optional<ArrayList<Message>> Messages = messageService.getMessageList(uid);
        if (Messages.isPresent()) {
            return ApiResponse.ok(Messages);
        } else {
            return ApiResponse.error("");
        }
    }
}

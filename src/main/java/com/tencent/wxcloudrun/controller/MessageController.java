package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.MessageService;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    final MessageService messageService;
    public MessageController(@Autowired MessageService messageService){
        this.messageService = messageService;
    }

}

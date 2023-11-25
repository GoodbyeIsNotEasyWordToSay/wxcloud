package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dto.MessageRequest;
import com.tencent.wxcloudrun.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public Optional<ArrayList<MessageRequest>> getMessage(int userid) {
        return Optional.empty();
    }
}

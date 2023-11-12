package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.LoginMapper;
import com.tencent.wxcloudrun.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    final LoginMapper loginMapper;

    public LoginServiceImpl(@Autowired LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Optional<Integer> getUID(String openID){
        Integer UID = loginMapper.getUID(openID);
        if(UID == null){
           loginMapper.insertUser(openID);
           UID = loginMapper.getUID(openID);
           return Optional.ofNullable(UID);
        }
        else{
            return Optional.of(UID);
        }
    }
}

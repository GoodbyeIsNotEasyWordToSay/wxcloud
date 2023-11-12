package com.tencent.wxcloudrun.service;

import java.util.Optional;

public interface LoginService {
    Optional<Integer> getUID(String openID);
}

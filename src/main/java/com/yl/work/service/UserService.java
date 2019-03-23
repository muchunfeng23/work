package com.yl.work.service;

import com.yl.work.entity.WxUserEntity;

public interface UserService {
    public Integer saveWxUser(WxUserEntity entity);
    public WxUserEntity getWxUserInfo(String openId);
}

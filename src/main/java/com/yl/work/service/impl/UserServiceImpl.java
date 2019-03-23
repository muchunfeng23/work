package com.yl.work.service.impl;

import com.yl.work.entity.WxUserEntity;
import com.yl.work.mapper.UserInfoMapper;
import com.yl.work.mapper.WxUserMapper;
import com.yl.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer saveWxUser(WxUserEntity entity) {
        return null;
    }

    @Override
    public WxUserEntity getWxUserInfo(String openId) {
        return null;
    }
}

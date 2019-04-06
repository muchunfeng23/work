package com.yl.work.controller;

import com.yl.work.entity.UserInfoEntity;
import com.yl.work.mapper.UserInfoMapper;
import com.yl.work.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nanhang")
public class NanHangController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("identiyCard")String idCard,
                          @RequestParam("phone")String phone){
        UserInfoEntity addedUser = new UserInfoEntity();
        addedUser.setUserName(userName);
        addedUser.setIdentiyCard(idCard);
        addedUser.setPhone(phone);
        if(addedUser != null){
            if(addedUser.getUserName() != null
                && addedUser.getIdentiyCard() != null
                && addedUser.getPhone() != null){
                addedUser.setCt(DateUtil.getCurrentTimeIntValue());
                userInfoMapper.insert(addedUser);
                return "ok";
            }
        }
        return "error";
    }

}

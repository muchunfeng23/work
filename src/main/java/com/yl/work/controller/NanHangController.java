package com.yl.work.controller;

import com.yl.work.entity.UserInfoEntity;
import com.yl.work.mapper.UserInfoMapper;
import com.yl.work.util.DateUtil;
import com.yl.work.util.IdCard;
import com.yl.work.util.PhoneCheker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nanhang")
public class NanHangController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserInfoEntity addedUser){
        if(addedUser != null){
            if(addedUser.getUserName() != null
                && addedUser.getIdentiyCard() != null
                && addedUser.getPhone() != null){

                IdCard idCard = new IdCard(addedUser.getIdentiyCard());
                if(idCard.isLegal() != 1){
                    return "idcard error";
                }
                if(!PhoneCheker.isPhoneLegal(addedUser.getPhone())){
                    return "phone error";
                }
                addedUser.setCt(DateUtil.getCurrentTimeIntValue());
                userInfoMapper.insert(addedUser);
                return "ok";
            }
        }
        return "error";
    }

}

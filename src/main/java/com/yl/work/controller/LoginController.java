package com.yl.work.controller;

import com.yl.work.weixin.LoginHelper;
import com.yl.work.weixin.WxCredentialUserHelper;
import com.yl.work.weixin.bean.OpenIdAndSessionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private WxCredentialUserHelper wxCredentialUserHelper;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String code = request.getParameter("code");
        OpenIdAndSessionKey openIdAndSessionKey = LoginHelper.getOpenIdAndSessionKey(code);
        String token = LoginHelper.createTokenForApp(openIdAndSessionKey);
        return token;
    }

    @RequestMapping("/uploadUserInfo")
    public String testServer(HttpServletRequest request, @RequestParam("uploadUserInfo")String uploadUserInfo,@RequestParam("user_token")String userToken){
        logger.info("user_token = " + userToken);
        String sessionKey = LoginHelper.getOpenIdAndSessionKey(userToken).getSession_key();
        logger.info("sessionKey = " + sessionKey);
        wxCredentialUserHelper.uploadLoginUserCredentialData(uploadUserInfo,sessionKey);
        System.out.println("-----  " + uploadUserInfo);
        return "ok";
    }
}

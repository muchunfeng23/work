package com.yl.work.controller;

import com.yl.work.weixin.LoginHelper;
import com.yl.work.weixin.bean.OpenIdAndSessionKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String code = request.getParameter("code");
        OpenIdAndSessionKey openIdAndSessionKey = LoginHelper.getOpenIdAndSessionKey(code);
        String token = LoginHelper.createTokenForApp(openIdAndSessionKey);
        return token;
    }
}

package com.yl.work.weixin;

import com.yl.work.config.ConfigInfo;
import com.yl.work.util.DateUtil;
import com.yl.work.util.JsonUtil;
import com.yl.work.util.YLHttpClient;
import com.yl.work.weixin.bean.OpenIdAndSessionKey;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LoginHelper {
    private static ConcurrentHashMap<String, OpenIdAndSessionKey> userTokenMap = new ConcurrentHashMap<>();

    public static OpenIdAndSessionKey getOpenIdAndSessionKey(String codeFromWx){
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?"
                + "appid=APPID"
                + "&secret=SECRET"
                + "&js_code=JSCODE"
                + "&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", ConfigInfo.APP_ID);
        requestUrl = requestUrl.replace("JSCODE", codeFromWx);
        requestUrl = requestUrl.replace("SECRET", ConfigInfo.APP_SECRET);
        //从微信服务器返回数据
        String jsonResult = YLHttpClient.doGetRequest(requestUrl);
        OpenIdAndSessionKey openIdAndSessionKey = JsonUtil.parseJson(jsonResult,OpenIdAndSessionKey.class);
        openIdAndSessionKey.setGetTime(DateUtil.getCurrentTimeIntValue());
        return openIdAndSessionKey;
    }

    /**
     * 生成app和服务端传递的token，当token失效时再去调用微信的openIdAndSessionKey
     * @return
     */
    public static String createTokenForApp(OpenIdAndSessionKey openIdAndSessionKey){
        String newToken = UUID.randomUUID().toString();
        //save newToken 和 openIdAndSessionKey的
        userTokenMap.put(newToken,openIdAndSessionKey);
        return newToken;
    }

    public static OpenIdAndSessionKey getOpenIdFromContext(String token){
        return userTokenMap.get(token);
    }
}

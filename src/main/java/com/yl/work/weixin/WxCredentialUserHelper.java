package com.yl.work.weixin;

import com.alibaba.fastjson.JSON;
import com.yl.work.util.AES;
import com.yl.work.weixin.bean.WxUserInfo;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class WxCredentialUserHelper {
    private Logger logger = LoggerFactory.getLogger(WxCredentialUserHelper.class);

    public void uploadLoginUserCredentialData(String userJsonStr,String sessionKey){
        logger.info(userJsonStr);
        WxUserInfo wxUserInfo = JSON.parseObject(userJsonStr,WxUserInfo.class);
        byte[] decodedEncryptedData = Base64.decode(wxUserInfo.getEncryptedData());
        byte[] aesKey = Base64.decode(sessionKey);
        byte[] iv = Base64.decode(wxUserInfo.getIv());
        AES aes = new AES();
        byte[] decodedContent = aes.decrypt(decodedEncryptedData,aesKey,iv);
        String afterDecode = new String(decodedContent);
        logger.info("after decode : " + afterDecode);
    }
}

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

    public static void main(String args[]){
        String userJsonStr = "{\n" +
                "\t\"errMsg\": \"getUserInfo:ok\",\n" +
                "\t\"rawData\": \"{\\\"nickName\\\":\\\"杨守中\\\",\\\"gender\\\":1,\\\"language\\\":\\\"zh_CN\\\",\\\"city\\\":\\\"Haidian\\\",\\\"province\\\":\\\"Beijing\\\",\\\"country\\\":\\\"China\\\",\\\"avatarUrl\\\":\\\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132\\\"}\",\n" +
                "\t\"userInfo\": {\n" +
                "\t\t\"nickName\": \"杨守中\",\n" +
                "\t\t\"gender\": 1,\n" +
                "\t\t\"language\": \"zh_CN\",\n" +
                "\t\t\"city\": \"Haidian\",\n" +
                "\t\t\"province\": \"Beijing\",\n" +
                "\t\t\"country\": \"China\",\n" +
                "\t\t\"avatarUrl\": \"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132\"\n" +
                "\t},\n" +
                "\t\"signature\": \"68920aa4ad60c33a2459c57cf7256100f2a1f442\",\n" +
                "\t\"encryptedData\": \"g94bK8sw/7WioWNraKtI9exjkET2vjtff6qGxuKMGVYJePUimI9MhETS/CasBzTH8HB41dMjd1vgmZwcRNmDpiloVWhwqZ5H1gq1zKbbZJ2JYHSL/Ic926tRGmVMKuY12NLCn1U6NVXYJSeT/mnGG6FXLO4XFC8iq6yDeJq4bF9JUdKnqKNm4zsunpLBg5gP2UxWGrhciE26JvlkrPJ9sZEt4QPuBdK6BPjcOIuGwIShjGuexTMfuQBZ8yVHd8XpMu2WIVaV1ttZ8ribyxaS1XXaeuEt7na5Ff752VEDbaJSCtfYoDL2KcB8VyI+8/oevK5EDBWXwfyTZpD+CVCVfKyc5idgHbSBMAbDZDRyvxekYuaqOwTSHJefifcYrpjO+SUs1w3C0LTolKBL/dN8BbWdNNzeGmHNk3/Hz0M4L90/vsUmdUcsrBY9oYAbd/Iacp/Gz8CQR1ehK7fkNvvlYwFmI9TOMqZsMxgdBxf0Ed8=\",\n" +
                "\t\"iv\": \"tyOuDJYqwLnFcpcyMhoRyg==\"\n" +
                "}";
        WxUserInfo wxUserInfo = JSON.parseObject(userJsonStr,WxUserInfo.class);
        byte[] decodedEncryptedData = Base64.decode(wxUserInfo.getEncryptedData());
//        byte[] aesKey = Base64.decode(sessionKey);
//        byte[] iv = Base64.decode(wxUserInfo.getIv());
//        AES aes = new AES();
//        byte[] decodedContent = aes.decrypt(decodedEncryptedData,aesKey,iv);
//        String afterDecode = new String(decodedContent);
//        logger.info("after decode : " + afterDecode);
    }
}

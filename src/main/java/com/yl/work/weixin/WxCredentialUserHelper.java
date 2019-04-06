package com.yl.work.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yl.work.entity.WxUserEntity;
import com.yl.work.mapper.WxUserMapper;
import com.yl.work.util.AES;
import com.yl.work.util.DateUtil;
import com.yl.work.weixin.bean.WxUserInfo;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 *
 */
@Service
public class WxCredentialUserHelper {
    private Logger logger = LoggerFactory.getLogger(WxCredentialUserHelper.class);

    @Autowired
    private WxUserMapper wxUserMapper;

    public void uploadLoginUserCredentialData(String userJsonStr,String sessionKey){
        WxUserInfo wxUserInfo = JSON.parseObject(userJsonStr,WxUserInfo.class);
        byte[] decodedEncryptedData = Base64.decode(wxUserInfo.getEncryptedData());
        byte[] aesKey = Base64.decode(sessionKey);
        byte[] iv = Base64.decode(wxUserInfo.getIv());
        AES aes = new AES();
        byte[] decodedContent = aes.decrypt(decodedEncryptedData,aesKey,iv);
        String afterDecode = new String(decodedContent);
        /**
         * {"openId":"orduW5NArjDLgNR6k5WmEdUkoXVQ",
         * "nickName":"杨守中","gender":1,"language":"zh_CN",
         * "city":"Haidian","province":"Beijing","country":"China",
         * "avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132",
         * "watermark":{"timestamp":1554528304,"appid":"wx71d957bf6d83f2de"}}
         */
        JSONObject jsonObject = JSONObject.parseObject(afterDecode);
        WxUserEntity wxUserEntity = new WxUserEntity();
        wxUserEntity.setOpenId(jsonObject.getString("openId"));
        wxUserEntity.setNickName(jsonObject.getString("nickName"));
        wxUserEntity.setGender(jsonObject.getInteger("gender"));
        wxUserEntity.setLanguage(jsonObject.getString("language"));
        wxUserEntity.setCity(jsonObject.getString("province"));
        wxUserEntity.setAvatarUrl(jsonObject.getString("avatarUrl"));
        wxUserEntity.setCountry(jsonObject.getString("country"));
        wxUserEntity.setCt(DateUtil.getCurrentTimeIntValue());
        wxUserMapper.insert(wxUserEntity);
    }

//    public static void main(String args[]){
//        String userJsonStr = "{\n" +
//                "\t\"errMsg\": \"getUserInfo:ok\",\n" +
//                "\t\"rawData\": \"{\\\"nickName\\\":\\\"杨守中\\\",\\\"gender\\\":1,\\\"language\\\":\\\"zh_CN\\\",\\\"city\\\":\\\"Haidian\\\",\\\"province\\\":\\\"Beijing\\\",\\\"country\\\":\\\"China\\\",\\\"avatarUrl\\\":\\\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132\\\"}\",\n" +
//                "\t\"userInfo\": {\n" +
//                "\t\t\"nickName\": \"杨守中\",\n" +
//                "\t\t\"gender\": 1,\n" +
//                "\t\t\"language\": \"zh_CN\",\n" +
//                "\t\t\"city\": \"Haidian\",\n" +
//                "\t\t\"province\": \"Beijing\",\n" +
//                "\t\t\"country\": \"China\",\n" +
//                "\t\t\"avatarUrl\": \"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132\"\n" +
//                "\t},\n" +
//                "\t\"signature\": \"68920aa4ad60c33a2459c57cf7256100f2a1f442\",\n" +
//                "\t\"encryptedData\": \"g94bK8sw/7WioWNraKtI9exjkET2vjtff6qGxuKMGVYJePUimI9MhETS/CasBzTH8HB41dMjd1vgmZwcRNmDpiloVWhwqZ5H1gq1zKbbZJ2JYHSL/Ic926tRGmVMKuY12NLCn1U6NVXYJSeT/mnGG6FXLO4XFC8iq6yDeJq4bF9JUdKnqKNm4zsunpLBg5gP2UxWGrhciE26JvlkrPJ9sZEt4QPuBdK6BPjcOIuGwIShjGuexTMfuQBZ8yVHd8XpMu2WIVaV1ttZ8ribyxaS1XXaeuEt7na5Ff752VEDbaJSCtfYoDL2KcB8VyI+8/oevK5EDBWXwfyTZpD+CVCVfKyc5idgHbSBMAbDZDRyvxekYuaqOwTSHJefifcYrpjO+SUs1w3C0LTolKBL/dN8BbWdNNzeGmHNk3/Hz0M4L90/vsUmdUcsrBY9oYAbd/Iacp/Gz8CQR1ehK7fkNvvlYwFmI9TOMqZsMxgdBxf0Ed8=\",\n" +
//                "\t\"iv\": \"tyOuDJYqwLnFcpcyMhoRyg==\"\n" +
//                "}";
//        WxUserInfo wxUserInfo = JSON.parseObject(userJsonStr,WxUserInfo.class);
//        byte[] decodedEncryptedData = Base64.decode(wxUserInfo.getEncryptedData());
//        byte[] aesKey = Base64.decode("2sCgpv0KgRAmZHS9DUVFOQ==");
//        // 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
//        int base = 16;
//        if (aesKey.length % base != 0) {
//            int groups = aesKey.length / base
//                    + (aesKey.length % base != 0 ? 1 : 0);
//            byte[] temp = new byte[groups * base];
//            Arrays.fill(temp, (byte) 0);
//            System.arraycopy(aesKey, 0, temp, 0, aesKey.length);
//            aesKey = temp;
//        }
//        byte[] iv = Base64.decode(wxUserInfo.getIv());
//        AES aes = new AES();
//        byte[] decodedContent = aes.decrypt(decodedEncryptedData,aesKey,iv);
//        String afterDecode = new String(decodedContent);
//        System.out.println("after decode : " + afterDecode);
//    }
}

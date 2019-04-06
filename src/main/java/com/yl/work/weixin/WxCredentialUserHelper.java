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
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

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
        List<WxUserEntity> readFromDB = wxUserMapper.select(wxUserEntity,null,null,null);

        wxUserEntity.setNickName(jsonObject.getString("nickName"));
        wxUserEntity.setGender(jsonObject.getInteger("gender"));
        wxUserEntity.setLanguage(jsonObject.getString("language"));
        wxUserEntity.setCity(jsonObject.getString("city"));
        wxUserEntity.setProvince(jsonObject.getString("province"));
        wxUserEntity.setAvatarUrl(jsonObject.getString("avatarUrl"));
        wxUserEntity.setCountry(jsonObject.getString("country"));
        wxUserEntity.setCt(DateUtil.getCurrentTimeIntValue());
        wxUserEntity.setDatekey(DateUtil.getTimesMonthmorning());
        if(CollectionUtils.isEmpty(readFromDB)){
            wxUserMapper.insert(wxUserEntity);
        }else{
            Integer id = readFromDB.get(0).getId();
            wxUserMapper.updateById(wxUserEntity,id);
        }

    }

}

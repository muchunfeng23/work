package com.yl.work.weixin.bean;

/**
 * {
 * 	"errMsg": "getUserInfo:ok",
 * 	"rawData": "{\"nickName\":\"杨守中\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Haidian\",\"province\":\"Beijing\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132\"}",
 * 	"userInfo": {
 * 		"nickName": "杨守中",
 * 		"gender": 1,
 * 		"language": "zh_CN",
 * 		"city": "Haidian",
 * 		"province": "Beijing",
 * 		"country": "China",
 * 		"avatarUrl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKNpepsCnC60YMwkDMNakGwgWrFgGDztyz6svo1FaafBUMzP6KyzkvUhMNpicc4dPdnyfZNoQiah8Gg/132"
 *        },
 * 	"signature": "d71bd5999aa3b9a00b4102b16625459eda51fe45",
 * 	"encryptedData": "BtlfjgOsOJTICq/QMZtq6gGGLvBT7Gvsdt5GvQWbm25X9yg3aVKsMNCCtfrVDAugfM+kWpByzG58uu/0Lx1066wErNyZPnonULfogcAq5d2fLTSsAv1TjFTs/wlKgMUuqCUrUXV/UAeREsHB0ndbMIrw7OXsNH5mqSRPHrwAbKOIyFj6LsLdFc5Sygz7rnoFg1MicJ+973oiY2MF4Ln7gozRCGvY/VAKS2urISInfSgrklhhtpP6BKtuO1xA0vHaIjUVUPzZ2/ENg1VD0vd2uBYRlNatfML2fzP7jFdtXMbLmOLCVSqDdazfiU4Q/qddgyMJGqDds8+atWE6ed0jZOzOyk7/BemlS+wTU3m5tc4C1WR5RFLfP6CktZQGg3vyLSPY0AyWd16u2Ml126OXTQFgaet1sbpr2hB3Ufu6HLBEKp/NQGUoizm+89wDTv/T2mZyrk93cf1Bja9JwIQlrNjcxFfN4F7FCabTgr6ZC9w=",
 * 	"iv": "xy/S7bylYkKI05HseAJRWQ=="
 * }
 */
public class WxUserInfo {
    private String errMsg;
    private String rawData;
    private String userInfo;
    private String signature;
    private String encryptedData;
    private String iv;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "WxUserInfo{" +
                "errMsg='" + errMsg + '\'' +
                ", rawData='" + rawData + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", signature='" + signature + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }
}

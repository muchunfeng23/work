package com.yl.work.weixin.bean;

public class OpenIdAndSessionKey {
    private String openid;
    private String session_key;
    private Integer getTime;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Integer getGetTime() {
        return getTime;
    }

    public void setGetTime(Integer getTime) {
        this.getTime = getTime;
    }

    @Override
    public String toString() {
        return "OpenIdAndSessionKey{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", getTime=" + getTime +
                '}';
    }
}

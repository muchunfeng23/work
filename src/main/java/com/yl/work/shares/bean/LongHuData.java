package com.yl.work.shares.bean;

import java.io.Serializable;
import java.util.List;

public class LongHuData implements Serializable {
    private static final long serialVersionUID = 4114514670424190091L;
    private String shareCode;
    private String shareName;
    private String sumAmount;
    private String everydaylhbSum;
    private List<String> everydaylhbData;
    private String plates;

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getEverydaylhbSum() {
        return everydaylhbSum;
    }

    public void setEverydaylhbSum(String everydaylhbSum) {
        this.everydaylhbSum = everydaylhbSum;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public List<String> getEverydaylhbData() {
        return everydaylhbData;
    }

    public void setEverydaylhbData(List<String> everydaylhbData) {
        this.everydaylhbData = everydaylhbData;
    }

    @Override
    public String toString() {
        return "LongHuData{" +
                "shareCode='" + shareCode + '\'' +
                ", shareName='" + shareName + '\'' +
                ", sumAmount='" + sumAmount + '\'' +
                ", everydaylhbSum='" + everydaylhbSum + '\'' +
                ", everydaylhbData=" + everydaylhbData +
                ", plates='" + plates + '\'' +
                '}';
    }
}

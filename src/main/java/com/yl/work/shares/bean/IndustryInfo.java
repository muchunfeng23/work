package com.yl.work.shares.bean;

import com.yl.work.entity.IndustryAmountEntity;

import java.util.List;
import java.util.Map;

public class IndustryInfo {
    private String platName;
    private Double amountSum;
    private List<IndustryAmountEntity> industryAmountEntityList;
    private Map<String,String> datekeyAmountMap;
    private String amountDetailStr;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public Double getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(Double amountSum) {
        this.amountSum = amountSum;
    }

    public List<IndustryAmountEntity> getIndustryAmountEntityList() {
        return industryAmountEntityList;
    }

    public void setIndustryAmountEntityList(List<IndustryAmountEntity> industryAmountEntityList) {
        this.industryAmountEntityList = industryAmountEntityList;
    }

    public String getAmountDetailStr() {
        return amountDetailStr;
    }

    public void setAmountDetailStr(String amountDetailStr) {
        this.amountDetailStr = amountDetailStr;
    }

    public Map<String, String> getDatekeyAmountMap() {
        return datekeyAmountMap;
    }

    public void setDatekeyAmountMap(Map<String, String> datekeyAmountMap) {
        this.datekeyAmountMap = datekeyAmountMap;
    }

    @Override
    public String toString() {
        return "IndustryInfo{" +
                "platName='" + platName + '\'' +
                ", amountSum=" + amountSum +
                ", industryAmountEntityList=" + industryAmountEntityList +
                ", datekeyAmountMap=" + datekeyAmountMap +
                ", amountDetailStr='" + amountDetailStr + '\'' +
                '}';
    }
}

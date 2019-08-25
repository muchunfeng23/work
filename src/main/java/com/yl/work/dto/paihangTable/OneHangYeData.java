package com.yl.work.dto.paihangTable;

import java.io.Serializable;
import java.util.List;

public class OneHangYeData implements Serializable {

    private static final long serialVersionUID = -1499446742129025451L;
    //行业名
    private String hangye;
    //按日期排序的数据
    private List<EveryDayData> everyDaySortData;
    //推荐的股票
    private List<String> shareNameList;

    public String getHangye() {
        return hangye;
    }

    public void setHangye(String hangye) {
        this.hangye = hangye;
    }

    public List<EveryDayData> getEveryDaySortData() {
        return everyDaySortData;
    }

    public void setEveryDaySortData(List<EveryDayData> everyDaySortData) {
        this.everyDaySortData = everyDaySortData;
    }

    public List<String> getShareNameList() {
        return shareNameList;
    }

    public void setShareNameList(List<String> shareNameList) {
        this.shareNameList = shareNameList;
    }

    @Override
    public String toString() {
        return "OneHangYeData{" +
                "hangye='" + hangye + '\'' +
                ", everyDaySortData=" + everyDaySortData +
                ", shareNameList=" + shareNameList +
                '}';
    }
}

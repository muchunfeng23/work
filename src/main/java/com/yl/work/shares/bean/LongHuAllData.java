package com.yl.work.shares.bean;

import java.util.List;
import java.util.Map;

public class LongHuAllData {
    private List<LongHuData> allLongHuDatas;
    private Map<String,List<LongHuData>> conceptMap;
    //按查询结果的净买入从大到小排序，方便整合返回结果
    private List<String> sortShareCodes;

    public List<LongHuData> getAllLongHuDatas() {
        return allLongHuDatas;
    }

    public void setAllLongHuDatas(List<LongHuData> allLongHuDatas) {
        this.allLongHuDatas = allLongHuDatas;
    }

    public Map<String, List<LongHuData>> getConceptMap() {
        return conceptMap;
    }

    public void setConceptMap(Map<String, List<LongHuData>> conceptMap) {
        this.conceptMap = conceptMap;
    }

    public List<String> getSortShareCodes() {
        return sortShareCodes;
    }

    public void setSortShareCodes(List<String> sortShareCodes) {
        this.sortShareCodes = sortShareCodes;
    }

    @Override
    public String toString() {
        return "LongHuAllData{" +
                "allLongHuDatas=" + allLongHuDatas +
                ", conceptMap=" + conceptMap +
                ", sortShareCodes=" + sortShareCodes +
                '}';
    }
}

package com.yl.work.dto;

import java.io.Serializable;
import java.util.List;

public class ConceptChangeData implements Serializable {
    private String conceptName;
    private String conceptDayIndex;
    private String paihangIndex;
    private String zhangdiefu;
    private String sumMoney;
    //当日排行越高分值越大；当日没进前N，不在排行之内
    private List<Integer> scoreList;
    private Integer score;
    private List<Double> percentList;

    public String getZhangdiefu() {
        return zhangdiefu;
    }

    public void setZhangdiefu(String zhangdiefu) {
        this.zhangdiefu = zhangdiefu;
    }

    public String getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }

    public List<Double> getPercentList() {
        return percentList;
    }

    public void setPercentList(List<Double> percentList) {
        this.percentList = percentList;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public String getPaihangIndex() {
        return paihangIndex;
    }

    public void setPaihangIndex(String paihangIndex) {
        this.paihangIndex = paihangIndex;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public String getConceptDayIndex() {
        return conceptDayIndex;
    }

    public void setConceptDayIndex(String conceptDayIndex) {
        this.conceptDayIndex = conceptDayIndex;
    }
}

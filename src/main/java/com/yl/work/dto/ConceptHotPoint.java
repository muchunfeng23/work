package com.yl.work.dto;

import java.io.Serializable;

public class ConceptHotPoint implements Serializable {
    private static final long serialVersionUID = -5796581322876261414L;

    private String hangye;
    //前十上榜次数
    private int before10Count;
    //后十上榜次数
    private int last10Count;
    //总共上榜次数
    private int allCount;

    public String getHangye() {
        return hangye;
    }

    public void setHangye(String hangye) {
        this.hangye = hangye;
    }

    public int getBefore10Count() {
        return before10Count;
    }

    public void setBefore10Count(int before10Count) {
        this.before10Count = before10Count;
    }

    public int getLast10Count() {
        return last10Count;
    }

    public void setLast10Count(int last10Count) {
        this.last10Count = last10Count;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    @Override
    public String toString() {
        return "ConceptHotPoint{" +
                "hangye='" + hangye + '\'' +
                ", before10Count=" + before10Count +
                ", last10Count=" + last10Count +
                ", allCount=" + allCount +
                '}';
    }
}

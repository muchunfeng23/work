package com.yl.work.dto.paihangTable;

import com.yl.work.common.ParentParamDto;

public class PageInfoParam extends ParentParamDto {
    private static final long serialVersionUID = 192858829378455554L;
    //展示多少天的数据
    private Integer showDays;
    //排序取前几天的数据
    private Integer beforeDays;
    private Integer dayIndexFrom;
    //排序取前几的比较
    private Integer beforePaiHang;
    private Integer paihangLimit;

    public Integer getShowDays() {
        return showDays;
    }

    public void setShowDays(Integer showDays) {
        this.showDays = showDays;
    }

    public Integer getBeforeDays() {
        return beforeDays;
    }

    public void setBeforeDays(Integer beforeDays) {
        this.beforeDays = beforeDays;
    }

    public Integer getDayIndexFrom() {
        return dayIndexFrom;
    }

    public void setDayIndexFrom(Integer dayIndexFrom) {
        this.dayIndexFrom = dayIndexFrom;
    }

    public Integer getBeforePaiHang() {
        return beforePaiHang;
    }

    public void setBeforePaiHang(Integer beforePaiHang) {
        this.beforePaiHang = beforePaiHang;
    }

    public Integer getPaihangLimit() {
        return paihangLimit;
    }

    public void setPaihangLimit(Integer paihangLimit) {
        this.paihangLimit = paihangLimit;
    }

    @Override
    public String toString() {
        return "PageInfoParam{" +
                "showDays=" + showDays +
                ", beforeDays=" + beforeDays +
                ", dayIndexFrom=" + dayIndexFrom +
                ", beforePaiHang=" + beforePaiHang +
                ", paihangLimit=" + paihangLimit +
                '}';
    }
}

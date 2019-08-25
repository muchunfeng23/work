package com.yl.work.dto.paihangTable;

import java.io.Serializable;

public class EveryDayData implements Serializable {
    private static final long serialVersionUID = -619426698291319166L;

    //1-end
    private Integer dayIndex;
    //1-280
    private Integer paihangIndex;

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public Integer getPaihangIndex() {
        return paihangIndex;
    }

    public void setPaihangIndex(Integer paihangIndex) {
        this.paihangIndex = paihangIndex;
    }

    @Override
    public String toString() {
        return "EveryDayData{" +
                "dayIndex=" + dayIndex +
                ", paihangIndex=" + paihangIndex +
                '}';
    }
}

package com.yl.work.dto;

import com.yl.work.entity.ThsConceptEverydayEntity;

public class HotConceptBeforeLastDto extends ThsConceptEverydayEntity {

    private Integer upOrDown;

    public Integer getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(Integer upOrDown) {
        this.upOrDown = upOrDown;
    }

    @Override
    public String toString() {
        return "HotConceptBeforeLastDto{" +
                "upOrDown=" + upOrDown +
                '}';
    }
}

package com.yl.work.mapper;

import com.yl.work.shares.bean.LongHuData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShareCommonMapper {
    public Integer getMaxDayIndex();

    public List<LongHuData> getLongHuData(@Param("dayIndexFrom") Integer dagIndexFrom);

    public List<LongHuData> onedayLongHuData();
}

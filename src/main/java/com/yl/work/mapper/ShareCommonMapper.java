package com.yl.work.mapper;

import com.yl.work.shares.bean.LongHuData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShareCommonMapper {
    public List<LongHuData> getLongHuData();
}

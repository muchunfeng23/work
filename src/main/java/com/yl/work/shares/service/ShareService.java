package com.yl.work.shares.service;

import com.yl.work.dto.paihangTable.OneHangYeData;
import com.yl.work.dto.paihangTable.PageInfoParam;
import com.yl.work.entity.ThsConceptEverydayEntity;
import com.yl.work.shares.bean.IndustryInfo;

import java.util.List;

public interface ShareService {
    public List<IndustryInfo> getPlatInfos(Integer days,Integer type);

    public List<ThsConceptEverydayEntity> selectHangYeDetail(PageInfoParam param);
    //查询最近概念变化趋势图
    public List<OneHangYeData> queryRecentConceptChangeData(PageInfoParam param);
    //获取最近交易日的所有的行业概念
    public List<String> showAllHangYe();

    public OneHangYeData queryOneHangyeData(String hangye);
}

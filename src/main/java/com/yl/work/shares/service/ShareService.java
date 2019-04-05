package com.yl.work.shares.service;

import com.yl.work.shares.bean.IndustryInfo;

import java.util.List;

public interface ShareService {
    public List<IndustryInfo> getPlatInfos(Integer days,Integer type);
}

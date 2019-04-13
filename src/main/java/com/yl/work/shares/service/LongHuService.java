package com.yl.work.shares.service;

import com.yl.work.shares.bean.LongHuAllData;
import com.yl.work.shares.bean.LongHuData;

import java.util.List;

public interface LongHuService {
    public List<LongHuData> getLongHuData();

    public LongHuAllData collectAllData();
}

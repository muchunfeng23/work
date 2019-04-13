package com.yl.work.shares.service.impl;

import com.yl.work.mapper.ShareCommonMapper;
import com.yl.work.shares.bean.LongHuAllData;
import com.yl.work.shares.bean.LongHuData;
import com.yl.work.shares.service.LongHuService;
import javafx.collections.transformation.SortedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class LongHuServiceImpl implements LongHuService {
    private Logger logger = LoggerFactory.getLogger(LongHuServiceImpl.class);

    @Autowired
    private ShareCommonMapper shareCommonMapper;

    @Override
    public List<LongHuData> getLongHuData() {
        return shareCommonMapper.getLongHuData();
    }

    @Override
    public LongHuAllData collectAllData() {
        List<LongHuData> allLongHuData = this.getLongHuData();
        LongHuAllData allData = new LongHuAllData();
        allData.setAllLongHuDatas(allLongHuData);
        Map<String,List<LongHuData>> conceptMap = new HashMap<String, List<LongHuData>>();
        //把每个概念相同的数据整合起来
        for(LongHuData longHuData : allLongHuData){
            List<String> allConceptForTheShare = this.splitConcept(longHuData.getPlates());
            if(!CollectionUtils.isEmpty(allConceptForTheShare)){
                for(String concept : allConceptForTheShare){
                    List<LongHuData> datasInMap = conceptMap.get(concept);
                    if(datasInMap == null){
                        datasInMap = new ArrayList<>();
                        conceptMap.put(concept,datasInMap);
                    }
                    datasInMap.add(longHuData);
                }
            }
            longHuData.setEverydaylhbData(this.sortEveryDayInOutData(longHuData.getEverydaylhbSum()));
        }
        //
        allData.setConceptMap(conceptMap);
        allData.setSortShareCodes(this.collectTitle(conceptMap));
        return allData;
    }

    private List<String> collectTitle(Map<String,List<LongHuData>> conceptMap){
        if(conceptMap == null || conceptMap.size() == 0){
            return null;
        }
        List<String> sortedTitle = new ArrayList<>();
        Map<Integer,String> countConceptMap = new TreeMap<>();
        for(Map.Entry<String,List<LongHuData>> aEntry : conceptMap.entrySet()){
            if(aEntry.getValue() != null){
                logger.info("------value");
                countConceptMap.put(aEntry.getValue().size(),aEntry.getKey());
            }
        }
        for(Map.Entry<Integer,String> sortEntry : countConceptMap.entrySet()){
            sortedTitle.add(sortEntry.getValue() + "(" + sortEntry.getKey() + ")");
        }
        return sortedTitle;
    }

    private List<String> sortEveryDayInOutData(String everydaylhbSum){
        if(everydaylhbSum == null || everydaylhbSum.trim().length() == 0){
            return null;
        }
        List<String> everydayDatas = new ArrayList<>();
        String[] everydays = everydaylhbSum.split(",");
        if(everydays != null){
            for(String everyday : everydays){
                everydayDatas.add(everyday.substring(1,everyday.length() - 1));
            }
        }
        return everydayDatas;
    }

    private List<String> splitConcept(String plates){
        if(plates == null || plates.trim().length() == 0){
            return null;
        }
        String[] allPlates = plates.split(",");
        return Arrays.asList(allPlates);
    }


}

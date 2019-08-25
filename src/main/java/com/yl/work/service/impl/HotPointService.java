package com.yl.work.service.impl;

import com.yl.work.dto.ConceptHotPoint;
import com.yl.work.dto.HotConceptBeforeLastDto;
import com.yl.work.mapper.ThsConceptEverydayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotPointService {
    @Autowired
    private ThsConceptEverydayMapper thsConceptEverydayMapper;

    public List<ConceptHotPoint> collectRecentHotPoints(){
        Integer maxDayIndex = thsConceptEverydayMapper.maxDayIndex();
        int searchCount = 0;
        int nowDayIndex = maxDayIndex;
        List<HotConceptBeforeLastDto> allHotConcepts = new ArrayList<>();
        while(nowDayIndex > 0 && searchCount < 5){
            allHotConcepts.addAll(this.collectOnedayHotPoints(nowDayIndex));
            searchCount++;
            nowDayIndex--;
        }

        List<ConceptHotPoint> result = new ArrayList<>();
        Map<String,ConceptHotPoint> hotConceptMap = new HashMap<>();
        for(HotConceptBeforeLastDto aDto : allHotConcepts){
            String hangye = aDto.getHangye();
            ConceptHotPoint conceptHotPoint = hotConceptMap.get(hangye);
            if(conceptHotPoint == null){
                conceptHotPoint = new ConceptHotPoint();
                conceptHotPoint.setHangye(hangye);
                hotConceptMap.put(hangye,conceptHotPoint);
            }
            Integer upOrDown = aDto.getUpOrDown();
            if(upOrDown == 1){
                conceptHotPoint.setBefore10Count(conceptHotPoint.getBefore10Count() + 1);
            }else if(upOrDown == -1){
                conceptHotPoint.setLast10Count(conceptHotPoint.getLast10Count() + 1);
            }
            conceptHotPoint.setAllCount(conceptHotPoint.getAllCount() + 1);
        }

        for(Map.Entry<String,ConceptHotPoint> aEntry : hotConceptMap.entrySet()){
            result.add(aEntry.getValue());
        }
        Collections.sort(result, new Comparator<ConceptHotPoint>() {
            @Override
            public int compare(ConceptHotPoint o1, ConceptHotPoint o2) {
                int allCount1 = o1.getAllCount();
                int allCount2 = o2.getAllCount();
                int beforeCount1 = o1.getBefore10Count();
                int beforeCount2 = o2.getBefore10Count();
                if(allCount1 > allCount2){
                    return -1;
                }else if(allCount1 < allCount2){
                    return 1;
                }else{
                    if(beforeCount1 > beforeCount2){
                        return -1;
                    }else if(beforeCount1 < beforeCount2){
                        return 1;
                    }
                    return 0;
                }
            }
        });
        return result;
    }

    public List<HotConceptBeforeLastDto> collectOnedayHotPoints(Integer dayIndex){
        return thsConceptEverydayMapper.collectOnedayHotPoints(dayIndex);
    }
}

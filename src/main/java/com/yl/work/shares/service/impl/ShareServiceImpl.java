package com.yl.work.shares.service.impl;

import com.yl.work.entity.IndustryAmountEntity;
import com.yl.work.mapper.ConceptAmountMapper;
import com.yl.work.mapper.IndustryAmountMapper;
import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.service.ShareService;
import com.yl.work.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private IndustryAmountMapper industryAmountMapper;

    @Autowired
    private ConceptAmountMapper conceptAmountMapper;

    @Override
    public List<IndustryInfo> getPlatInfos(Integer days,Integer type) {
        Integer fromDatekey = this.getThatDatekey(days);
        if(fromDatekey != null){
            List<IndustryInfo> industryInfos = null;
            if(type == 1 || type == 2){
                String descAsc = type == 1?"desc":"asc";
                industryInfos = industryAmountMapper.queryIndustryInfos(fromDatekey,descAsc);
            }else if(type == 3 || type == 4){
                String descAsc = type == 3?"desc":"asc";
                industryInfos = conceptAmountMapper.queryIndustryInfos(fromDatekey,descAsc);
            }
            if(CollectionUtils.isEmpty(industryInfos)){
                return null;
            }else{
                for(IndustryInfo industryInfo : industryInfos){
                    String industryDetailInfos = industryInfo.getAmountDetailStr();
                    Map<String,String> datekeyAndAmountMap = new HashMap<String,String>();
                    String[] splitInfos = industryDetailInfos.split(",");
                    for(String aInfo : splitInfos){
                        String keyValue[] = aInfo.split("\\|");
                        datekeyAndAmountMap.put(keyValue[1],keyValue[0]);
                    }
                    List<IndustryAmountEntity> industryAmountEntityList = new ArrayList<>();
                    for(int calcFrom = 0; calcFrom <= days; calcFrom++){
                        Integer calcFromDatekey = this.getThatDatekey(days - calcFrom);
                        IndustryAmountEntity returnEntity = new IndustryAmountEntity();
                        returnEntity.setIname(industryInfo.getPlatName());
                        returnEntity.setDatekey(calcFromDatekey);
                        if(datekeyAndAmountMap.get(""+calcFromDatekey) != null){
                            returnEntity.setAmount(Double.parseDouble(datekeyAndAmountMap.get(""+calcFromDatekey)));
                        }else{
                            returnEntity.setAmount(0.0);
                        }
                        industryAmountEntityList.add(returnEntity);
                    }
                    industryInfo.setIndustryAmountEntityList(industryAmountEntityList);
                    industryInfo.setDatekeyAmountMap(datekeyAndAmountMap);
                }
            }
            return industryInfos;
        }
        return null;
    }

    private Integer getThatDatekey(Integer daysBefore){
        Integer datekey7day = DateUtil.getTimesmorning(new Date(System.currentTimeMillis() - daysBefore.longValue() * 3600 * 24 * 1000));
        Integer thatDatekey = null;
        try {
            String fromDatekeyStr = DateUtil.getDateStringByTimeStamp(datekey7day,"yyyyMMdd");
            thatDatekey = Integer.parseInt(fromDatekeyStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return thatDatekey;
    }
}

package com.yl.work.shares.service.impl;

import com.github.pagehelper.PageHelper;
import com.yl.work.common.PageEntity;
import com.yl.work.dto.paihangTable.EveryDayData;
import com.yl.work.dto.paihangTable.OneHangYeData;
import com.yl.work.dto.paihangTable.PageInfoParam;
import com.yl.work.entity.IndustryAmountEntity;
import com.yl.work.entity.ThsConceptEverydayEntity;
import com.yl.work.mapper.ConceptAmountMapper;
import com.yl.work.mapper.IndustryAmountMapper;
import com.yl.work.mapper.ThsConceptEverydayMapper;
import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.service.ShareService;
import com.yl.work.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private IndustryAmountMapper industryAmountMapper;

    @Autowired
    private ConceptAmountMapper conceptAmountMapper;

    @Autowired
    private ThsConceptEverydayMapper thsConceptEverydayMapper;

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

    @Override
    public List<ThsConceptEverydayEntity> selectHangYeDetail(PageInfoParam param) {
        //获取当前最后的dayIndex
        Integer maxDayIndex = thsConceptEverydayMapper.maxDayIndex();
        //取出排序数据
        Integer dayIndexFrom = maxDayIndex - param.getBeforeDays();
        Integer paihangLimit = param.getBeforePaiHang();
        param.setDayIndexFrom(dayIndexFrom);
        param.setPaihangLimit(paihangLimit);
        //填充最近几日数据
//        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<String> allHangyeList = thsConceptEverydayMapper.selectHangYePaiHang(param);
//        PageEntity<String> pageEntity = new PageEntity<>(allHangyeList);

        return thsConceptEverydayMapper.selectHangYeDetail(param.getShowDays(),allHangyeList);
    }

    @Override
    public List<OneHangYeData> queryRecentConceptChangeData(PageInfoParam param) {
        //1、获取排序数据并初始化返回值
        //获取当前最后的dayIndex
        Integer maxDayIndex = thsConceptEverydayMapper.maxDayIndex();
        //取出排序数据
        Integer dayIndexFrom = maxDayIndex - param.getBeforeDays();
        Integer paihangLimit = param.getBeforePaiHang();
        param.setDayIndexFrom(dayIndexFrom);
        param.setPaihangLimit(paihangLimit);
        List<String> allHangyeList = thsConceptEverydayMapper.selectHangYePaiHang(param);
        List<OneHangYeData> returnList = new ArrayList<>();
        for(String hangye : allHangyeList){
            OneHangYeData oneHangYeData = new OneHangYeData();
            oneHangYeData.setHangye(hangye);
            returnList.add(oneHangYeData);
        }
        //填充
        Integer newDayIndexFrom = maxDayIndex - param.getShowDays();
        List<ThsConceptEverydayEntity> everydayEntities = thsConceptEverydayMapper.selectHangYeDetail(newDayIndexFrom,allHangyeList);
        Map<String,List<ThsConceptEverydayEntity>> hangYeMap = everydayEntities.stream()
                .sorted(Comparator.comparing(ThsConceptEverydayEntity::getDayIndex))
                .collect(Collectors.groupingBy(ThsConceptEverydayEntity::getHangye,
                        Collectors.mapping(t->t,Collectors.toList())));

        for(OneHangYeData oneHangYeData : returnList){
            String hangye = oneHangYeData.getHangye();
            List<ThsConceptEverydayEntity> ownedList = hangYeMap.get(hangye);
            List<EveryDayData> everyDayDataList = new ArrayList<>();
            Set<String> mainShares = new HashSet<>();
            for(ThsConceptEverydayEntity everydayEntity : ownedList){
                EveryDayData everyDayData = new EveryDayData();
                everyDayData.setDayIndex(everydayEntity.getDayIndex());
                everyDayData.setPaihangIndex(everydayEntity.getPaihangIndex());
                everyDayDataList.add(everyDayData);
                mainShares.add(everydayEntity.getMainshare());
            }
            oneHangYeData.setEveryDaySortData(everyDayDataList);
            oneHangYeData.setShareNameList(new ArrayList<>(mainShares));
        }
        return returnList;
    }

    @Override
    public List<String> showAllHangYe() {
        //1、查询最近交易日的所有概念
        Integer maxDayIndex = thsConceptEverydayMapper.maxDayIndex();
        return thsConceptEverydayMapper.showAllHangYe(maxDayIndex);
    }

    @Override
    public OneHangYeData queryOneHangyeData(String hangye1) {
        Integer maxDayIndex = thsConceptEverydayMapper.maxDayIndex();
        Integer newDayIndexFrom = maxDayIndex - 30;
        List<String> allHangyeList = new ArrayList<>(Arrays.asList(hangye1));

        List<ThsConceptEverydayEntity> everydayEntities = thsConceptEverydayMapper.selectHangYeDetail(newDayIndexFrom,allHangyeList);
        //下面功能直接复制的上面的，偷懒了
        Map<String,List<ThsConceptEverydayEntity>> hangYeMap = everydayEntities.stream()
                .sorted(Comparator.comparing(ThsConceptEverydayEntity::getDayIndex))
                .collect(Collectors.groupingBy(ThsConceptEverydayEntity::getHangye,
                        Collectors.mapping(t->t,Collectors.toList())));
        List<OneHangYeData> returnList = new ArrayList<>();
        for(String hangye : allHangyeList){
            OneHangYeData oneHangYeData = new OneHangYeData();
            oneHangYeData.setHangye(hangye);
            returnList.add(oneHangYeData);
        }
        for(OneHangYeData oneHangYeData : returnList){
            String hangye = oneHangYeData.getHangye();
            List<ThsConceptEverydayEntity> ownedList = hangYeMap.get(hangye);
            List<EveryDayData> everyDayDataList = new ArrayList<>();
            Set<String> mainShares = new HashSet<>();
            for(ThsConceptEverydayEntity everydayEntity : ownedList){
                EveryDayData everyDayData = new EveryDayData();
                everyDayData.setDayIndex(everydayEntity.getDayIndex());
                everyDayData.setPaihangIndex(everydayEntity.getPaihangIndex());
                everyDayDataList.add(everyDayData);
                mainShares.add(everydayEntity.getMainshare());
            }
            oneHangYeData.setEveryDaySortData(everyDayDataList);
            oneHangYeData.setShareNameList(new ArrayList<>(mainShares));
        }
        return returnList.get(0);
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

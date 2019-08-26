package com.yl.work;

import com.yl.work.entity.ConceptAmountEntity;
import com.yl.work.mapper.ConceptAmountMapper;
import com.yl.work.mapper.ShareCommonMapper;
import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.bean.LongHuData;
import com.yl.work.shares.service.LongHuService;
import com.yl.work.shares.service.ShareService;
import com.yl.work.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {
    @Autowired
    private ConceptAmountMapper conceptAmountMapper;

    @Autowired
    private ShareService shareService;

    @Autowired
    private ShareCommonMapper shareCommonMapper;

    @Autowired
    private LongHuService longHuService;

    @Test
    public void getLongHuData(){
        List<LongHuData> longHuData = shareCommonMapper.getLongHuData(249);
        System.out.println(longHuData);
    }

    @Test
    public void contextLoads() {
        ConceptAmountEntity aEntity = new ConceptAmountEntity();
        aEntity.setCname("你好");
        List<ConceptAmountEntity> result = conceptAmountMapper.select(aEntity,null,null,null);
        System.out.println("size = " + result.size());
    }

    @Test
    public void testDatekey(){
        Integer datekey7day = DateUtil.getTimesmorning(new Date(System.currentTimeMillis() - 7l * 3600 * 24 * 1000));
        try {
            String fromDatekey = DateUtil.getDateStringByTimeStamp(datekey7day,"yyyyMMdd");
            System.out.println(fromDatekey);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPlatInfos(){
        List<IndustryInfo> data = shareService.getPlatInfos(7,1);
        System.out.println(data);
    }

    @Test
    public void testLongHuData(){
        longHuService.collectAllData();
    }

}

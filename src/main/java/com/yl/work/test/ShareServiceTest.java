package com.yl.work.test;

import com.yl.work.dto.ConceptHotPoint;
import com.yl.work.dto.paihangTable.PageInfoParam;
import com.yl.work.service.impl.HotPointService;
import com.yl.work.shares.service.ShareService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShareServiceTest extends BaseTest{
    @Autowired
    private HotPointService hotPointService;

    @Autowired
    private ShareService shareService;

    @Test
    public void testShareConcept(){
        List<ConceptHotPoint> result = hotPointService.collectRecentHotPoints();
        System.out.println(result);
    }

    @Test
    public void testPaihang(){
        PageInfoParam param = new PageInfoParam();
        param.setBeforeDays(2);
        param.setBeforePaiHang(10);
        param.setShowDays(10);
//        shareService.selectHangYeDetail(param);
        shareService.queryRecentConceptChangeData(param);
    }
}

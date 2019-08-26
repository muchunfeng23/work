package com.yl.work.controller;

import com.yl.work.dto.paihangTable.OneHangYeData;
import com.yl.work.dto.paihangTable.PageInfoParam;
import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.bean.LongHuAllData;
import com.yl.work.shares.service.LongHuService;
import com.yl.work.shares.service.ShareService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.ModalExclude;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shares")
public class ShareController {
    private Logger logger = LoggerFactory.getLogger(ShareController.class);

    @Autowired
    private ShareService shareService;

    @Autowired
    private LongHuService longHuService;

    @RequestMapping("/plateInfo")
    public ModelAndView renderPlateAndConceptInfo(@RequestParam(value="searchParam",required = false)Integer searchParam){
        if(searchParam == null){
            searchParam = 1;
        }
        ModelAndView mv = new ModelAndView();
        List<IndustryInfo> industryInfoList = shareService.getPlatInfos(7,searchParam);
        mv.addObject("industryList",industryInfoList);
        mv.setViewName("platesDataShow");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/longhuData")
    public LongHuAllData longhuData(){
        LongHuAllData allData = longHuService.collectAllData();
        return allData;
    }

    @ResponseBody
    @RequestMapping("/longhuOnedayData")
    public LongHuAllData longhuOnedayData(){
        LongHuAllData allData = longHuService.collectOnedayLonghu();
        return allData;
    }

    //龙虎榜数据统计
    @ResponseBody
    @RequestMapping("/platesData")
    public List<IndustryInfo>  platesData(@RequestParam(value="searchParam",required = false)Integer searchParam){
        if(searchParam == null){
            searchParam = 1;
        }
        ModelAndView mv = new ModelAndView();
        List<IndustryInfo> industryInfoList = shareService.getPlatInfos(7,searchParam);
        return industryInfoList;
    }

    @RequestMapping("paihangShow")
    public ModelAndView paihangData(@RequestParam(value="recentDays",required = false)Integer recentDays,
                                    @RequestParam(value="paihangRows",required = false)Integer paihangRows){
        if(recentDays == null){
            recentDays = 1;
        }
        if(paihangRows == null){
            paihangRows = 10;
        }
        ModelAndView mv = new ModelAndView();
        PageInfoParam param = new PageInfoParam();
        param.setBeforeDays(recentDays);
        param.setBeforePaiHang(paihangRows);
        param.setShowDays(30);
        List<OneHangYeData> returnData = shareService.queryRecentConceptChangeData(param);
        mv.addObject("allHangYeDataList",returnData);
        mv.addObject("recentDaysIndex",recentDays);
        mv.addObject("paihangRowsIndex",paihangRows);
        mv.setViewName("paihangDataShow");
        return mv;
    }

    @RequestMapping("allConcept")
    public ModelAndView showAllConcepts(){
        ModelAndView mv = new ModelAndView();
        List<String> allHangye = shareService.showAllHangYe();
        mv.addObject("allHangye",allHangye);
        mv.setViewName("allConcept");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value="showOneConcept",method= RequestMethod.POST)
    public OneHangYeData showOneConceptData(@RequestBody Map<String,String> hangye){
        System.out.println("hangye = " + hangye.get("hangye"));
        OneHangYeData returndata = shareService.queryOneHangyeData(hangye.get("hangye"));
        return returndata;
    }
}

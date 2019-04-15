package com.yl.work.controller;

import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.bean.LongHuAllData;
import com.yl.work.shares.service.LongHuService;
import com.yl.work.shares.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}

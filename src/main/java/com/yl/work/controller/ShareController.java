package com.yl.work.controller;

import com.yl.work.shares.bean.IndustryInfo;
import com.yl.work.shares.bean.LongHuAllData;
import com.yl.work.shares.service.LongHuService;
import com.yl.work.shares.service.ShareService;
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

    @RequestMapping("/longhuData")
    public LongHuAllData returnString(){
        return longHuService.collectAllData();
    }

    //龙虎榜数据统计
    @ResponseBody
    @RequestMapping("/hello")
    public String nihao(){
        return "hello";
    }
}

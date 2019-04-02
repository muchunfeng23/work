package com.yl.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShareController {

    @RequestMapping("/plateInfo.mc")
    public ModelAndView renderPlateAndConceptInfo(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("a");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String nihao(){
        return "hello";
    }
}

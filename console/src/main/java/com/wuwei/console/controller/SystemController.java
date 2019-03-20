package com.wuwei.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther XuXin
 * @date 2019/3/14 16:50
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    /**
     * 动态加载页面
     * @param station
     * @param para
     * @return
     */
    @RequestMapping("/{station}/{para}")
    public ModelAndView getSystemPage(@PathVariable("station") String station,
                                @PathVariable("para") String para){
        ModelAndView mv=new ModelAndView();
        mv.setViewName(station+"/"+para);
        return mv;
    }

}

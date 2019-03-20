package com.wuwei.console.controller;

import com.wuwei.console.service.FluxOutsideService;
import com.wuwei.core.entity.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data/")
public class FluxOutsideController {
    @Autowired
    private FluxOutsideService fluxOutsideService;

    @RequestMapping("/flux_outside")
    @ResponseBody
    public ResultMap getFlux(int curr,int nums){
        return fluxOutsideService.getFlux(curr,nums);
    }


}

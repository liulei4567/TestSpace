package com.wuwei.console.service;

import com.wuwei.core.dao.FluxOutsideDao;
import com.wuwei.core.entity.FluxOutsideMin10;
import com.wuwei.core.entity.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class FluxOutsideService {

    @Autowired
    private FluxOutsideDao fluxOutsideDao;




    public ResultMap getFlux(int pagenum,int pageSize) {
        int pageStart=(pagenum-1)*pageSize;
        Map<String,Object> queryMap=new HashMap<>();
        queryMap.put("pageStart",pageStart);
        queryMap.put("pageSize",pageSize);
        List<FluxOutsideMin10> min10List=fluxOutsideDao.getFlux(queryMap);
        ResultMap<List<FluxOutsideMin10>> result=new ResultMap<>(0,"返回成功",this.getTotalCount(),min10List);
        return result;
    }

    private Long getTotalCount(){
        return fluxOutsideDao.totalCount();
    }
}

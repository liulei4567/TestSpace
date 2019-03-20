package com.wuwei.core.dao;

import com.wuwei.core.entity.FluxOutsideMin10;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface FluxOutsideDao {


    List<FluxOutsideMin10> getFlux(Map<String,Object> queryMap);

    long totalCount();
}

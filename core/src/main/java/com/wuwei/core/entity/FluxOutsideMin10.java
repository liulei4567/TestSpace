package com.wuwei.core.entity;

import java.util.Date;

public class FluxOutsideMin10 {
    //时间标签
    private Date tmStamp;
    private long recNum;
    private float albedoAvg;
    private float rSwInAvg;
    private float rSwOutAvg;

    public Date getTmStamp() {
        return tmStamp;
    }

    public void setTmStamp(Date tmStamp) {
        this.tmStamp = tmStamp;
    }

    public long getRecNum() {
        return recNum;
    }

    public void setRecNum(long recNum) {
        this.recNum = recNum;
    }

    public float getAlbedoAvg() {
        return albedoAvg;
    }

    public void setAlbedoAvg(float albedoAvg) {
        this.albedoAvg = albedoAvg;
    }

    public float getrSwInAvg() {
        return rSwInAvg;
    }

    public void setrSwInAvg(float rSwInAvg) {
        this.rSwInAvg = rSwInAvg;
    }

    public float getrSwOutAvg() {
        return rSwOutAvg;
    }

    public void setrSwOutAvg(float rSwOutAvg) {
        this.rSwOutAvg = rSwOutAvg;
    }
}

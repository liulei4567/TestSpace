package com.wuwei.core.entity;

import java.util.List;

/**
 * layui表格数据返回信息封装
 *
 * @auther XuXin
 * @date 2019/3/15 12:42
 */
public class ResultMap<T> {
    private int code;//true
    private String msg;//返回成功
    private long count;
    private T data;//list信息

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultMap(int code, String msg, long count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}

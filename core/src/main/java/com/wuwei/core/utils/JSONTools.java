package com.wuwei.core.utils;


import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * JSON工具类<br>
 * Created by ffw team on 2016/11/29.
 * @version 1.0
 */
public class JSONTools {
    private final static Gson gson = new Gson();

    /**
     * 指定对象转换成JSON数据<br>
     * Obj To json
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        if (obj == null)
            return "";
        return gson.toJson(obj);
    }

    /**
     * JSON转换成指定的对象<br>
     * json To T
     * @param json
     * @param cls
     * @param <T>
     * @return T
     */
    public static <T> T parserJson(String json, Class<T> cls) {
        if (StringTools.isEmpty(json))
            return null;
        return gson.fromJson(json, cls);
    }

    /**
     * JSON转成指定对象
     * @param json
     * @param typeOfT
     * @param <T>
     * @return
     */
    public static <T> T parserJson(String json, Type typeOfT) {
        if (StringTools.isEmpty(json))
            return null;
        return gson.fromJson(json, typeOfT);
    }
}

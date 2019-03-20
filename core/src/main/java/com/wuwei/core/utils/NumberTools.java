package com.wuwei.core.utils;

import java.util.Random;

/**
 * Created by henrybit on 2017/7/14.
 * @version 1.0
 */
public class NumberTools {

    /**
     * 字符串转long
     * @param str
     * @return long
     */
    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 字符串转Int
     * @param str
     * @return int
     */
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 字符串转Double<br>
     * @param str
     * @return double
     */
    public static double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
        }
        return -1D;
    }

    /**
     * 字符串转Float<br>
     * @param str
     * @return float
     */
    public static float stringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
        }
        return -1F;
    }

    /**
     * 获取start-end之间的随机数
     * @param start
     * @param end
     * @return
     */
    public static int randomIn(int start, int end) {
        Random random = new Random();
        int r = random.nextInt(end-start);
        return r+start;
    }

    /**
     * 获取0-limit之间的任意随机数
     * @param limit
     * @return
     */
    public static int randomIn(int limit) {
        Random random = new Random();
        int m = random.nextInt(limit);
        return m;
    }
}

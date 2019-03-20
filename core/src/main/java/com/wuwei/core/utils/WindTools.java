package com.wuwei.core.utils;

/**
 * 风向风速单位工具类
 */
public class WindTools {

    /**
     * 将风向度数转换为方向
     *
     * @param angle 度数
     * @return 方向字符串
     */
    public static String toDirection(double angle) {
        if (angle >= 0 && angle <= 22.5 || angle > 337.5 && angle <= 360) {
            return "北";
        } else if (angle > 22.5 && angle <= 67.5) {
            return "东北";
        } else if (angle > 67.5 && angle <= 112.5) {
            return "东";
        } else if (angle > 112.5 && angle <= 157.5) {
            return "东南";
        } else if (angle > 157.5 && angle <= 202.5) {
            return "南";
        } else if (angle > 202.5 && angle <= 247.5) {
            return "西南";
        } else if (angle > 247.5 && angle <= 292.5) {
            return "西";
        } else if (angle > 292.5 && angle <= 337.5) {
            return "西北";
        } else {
            return "--";
        }
    }
}

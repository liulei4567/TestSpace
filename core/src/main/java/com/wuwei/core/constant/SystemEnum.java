package com.wuwei.core.constant;

/**
 * 子系统枚举定义
 */
public enum SystemEnum {

    ALL(0, "全部子系统"),
    CZQXZ(1, "船载气象站"),
    NJDY(2, "能见度仪"),
    TDQXGC(3, "梯度气象观测系统"),
    HQWDTLGC(4, "海气涡度通量观测系统"),
    HQTDTLGC(5, "海气梯度通量观测系统"),
    QRJGC(6, "气溶胶观测系统"),
    QZDTKCXY(7, "全自动天空成像仪"),
    CZGKQXYC(8, "船载高空气象预测系统"),
    WBFSJ(9, "微波辐射计"),
    CZJGLDGC(10, "船载激光雷达观测系统"),
    YGY(11, "云高仪"),
    UNDEFINED(-1, "未知子系统");

    private int id;
    private String name;

    /**
     * 根据给定的系统ID返回对应的系统枚举
     *
     * @param systemId 系统ID
     * @return 枚举值
     */
    public static SystemEnum fromId(int systemId) {
        switch (systemId) {
            case 0:
                return ALL;
            case 1:
                return CZQXZ;
            case 2:
                return NJDY;
            case 3:
                return TDQXGC;
            case 4:
                return HQWDTLGC;
            case 5:
                return HQTDTLGC;
            case 6:
                return QRJGC;
            case 7:
                return QZDTKCXY;
            case 8:
                return CZGKQXYC;
            case 9:
                return WBFSJ;
            case 10:
                return CZJGLDGC;
            case 11:
                return YGY;
            default:
                return UNDEFINED;
        }
    }

    /**
     * 系统枚举构造函数
     *
     * @param id   系统ID
     * @param name 系统名称
     */
    SystemEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取系统ID
     *
     * @return 系统ID
     */
    public int getId() {
        return id;
    }

    /**
     * 获取系统名称
     *
     * @return 系统名称
     */
    public String getName() {
        return name;
    }
}

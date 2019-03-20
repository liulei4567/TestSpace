package com.wuwei.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间工具<br>
 * Created by ffw team on 2016/11/29.
 * @version 1.0
 */
public class TimeTools {

    //周日-64,周一-1,周二-2,周三-4,周四-8,周五-16,周六-32
    private final static int[] weekArray = new int[]{64,1,2,4,8,16,32};
    //西方式季度(1-3:1,4-6:2,7-9:3,10-12:4)
    private final static int[] quarterArray = new int[]{1,2,3,4};
    //中国式季度(3-5:春季,6-8:夏季,9-11:秋季,12-2:冬季)
    private final static int[] chinaQuarterArray = new int[]{1,2,3,4};

    private final static int[] monthDayLessArray = {31,28,31,30,31,30,31,31,30,31,30,31};
    private final static int[] monthDayMoreArray = {31,29,31,30,31,30,31,31,30,31,30,31};

    //private final static Calendar calendar = Calendar.getInstance();
    private final static SimpleDateFormat sdf_YYYY_MM = new SimpleDateFormat("yyyy-MM");
    private final static SimpleDateFormat sdf_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdf_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat sdf_MM_DD_YYYY = new SimpleDateFormat("MM/dd/yyyy");
    private final static SimpleDateFormat sdf_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 判断当前周是否在所有周期计算值内
     * @param weekDay 所有周期的计算值
     * @param curWeekDay 当前周期值
     * @return boolean-true:在;false:不在.
     */
    public static boolean existWeek(int weekDay, int curWeekDay) {
        if (curWeekDay <= 0)
            return false;
        boolean[] array = new boolean[7];
        for (int i=0; i<array.length; i++) {
            array[i] = false;
        }
        int weekMax = 64;
        while(true) {
            if (weekMax <= 0)
                break;
            if (weekDay > weekMax) {
                weekDay -= weekMax;
                if (weekMax == curWeekDay)
                    return true;
            } else if (weekDay == weekMax) {
                if (weekDay == curWeekDay)
                    return true;
                else
                    return false;
            }
            weekMax/=2;
        }
        if (weekDay == curWeekDay) {
            System.out.println(weekDay+"-"+curWeekDay);
            return true;
        }
        return false;
    }

    /**
     * 获取当前时间<br>
     * @return Date
     */
    public static Date getCurrentDate() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
//        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        calendar.setTime(new Date());
//        return calendar.getTime();
        return new Date();
    }

    public static int getCurrentHour() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static int getCurrentMinute() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.MINUTE);
        return hour;
    }

    /**
     * 获取当前时间在本周的周几<br>
     * @return int
     */
    public static int getCurrentDayOfWeek() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        return dayNum;
    }

    public static Date getCurrentDayMin(int subDay) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DAY_OF_YEAR, subDay);
        return cal.getTime();
    }

    public static Date getCurrentDayMin() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getCurrentDayMin(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getCurrentDayMin(long time, int subDay) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(Calendar.DAY_OF_YEAR, subDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取本月第一天
     * @param time
     * @return
     */
    public static Date getMonthFristDay(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static Date addDayOneDay(long time, int dayOfNum) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(Calendar.DAY_OF_YEAR, dayOfNum);
        return cal.getTime();
    }

    public static Date addDayOneDay(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public static Date addCurrentDayTowHours() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 120);
        return cal.getTime();
    }

    public static Date addCurrentDayTenMinutes() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 10);
        return cal.getTime();
    }

    public static Date addCurrentDayHalfHour() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 30);
        return cal.getTime();
    }

    public static Date addCurrentDayTwoHour() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 120);
        return cal.getTime();
    }

    public static Date addTowHour(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 120);
        return cal.getTime();
    }

    public static Date yesterday() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date subCurrentDayTwoHour() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -120);
        return cal.getTime();
    }

    public static Date getCurrentDayMax(int subDay) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.add(Calendar.DAY_OF_YEAR, subDay);
        return cal.getTime();
    }

    public static Date getCurrentDayMax() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getCurrentDayMax(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getCurrentMonthMin(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getCurrentMonthMax(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        if (((year%4==0) && (year%100!=0)) || (year%400==0))
            cal.set(Calendar.DAY_OF_MONTH, monthDayMoreArray[month]);//润年
        else
            cal.set(Calendar.DAY_OF_MONTH, monthDayLessArray[month]);//平年
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取当前星期几相应的值
     * @return int
     */
    public static int getCurrentWeek() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        int dp = calendar.get(Calendar.DAY_OF_WEEK);
        return weekArray[dp-1];
    }

    /**
     * 获取当前星期几
     * @return
     */
    public static int getCurrentRealWeek() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        int dp = calendar.get(Calendar.DAY_OF_WEEK);
        return dp;
    }

    /**
     * 获取当前年份
     * @return
     */
    public static int getCurrentYear() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }

    public static int getCurrentWeekOfYear() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getCurrentDayOfYear() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int getCurrentQuarter() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar calendar = Calendar.getInstance();
        return getQuarter(calendar.getTime());
    }

    public static long getTime(int year, int month) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        return cal.getTime().getTime();
    }

    /**
     * 获取当前天00:00:00
     * @return
     */
    public static Date getCurrentDay() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间的当天00:00:00
     * @param time
     * @return Date
     */
    public static Date getCurrentDay(long time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前时间毫秒数<br>
     * @return long
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取指定时间的天
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定时间的小时数
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定时间的分钟数
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    public static int getDayOfWeek(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static Date parserYYYYMMDD(String day) {
        try {
            return sdf_YYYY_MM_DD.parse(day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurrentDate();
    }

    public static Date parserYYYYMMDD_ADDHOUR(String day) {
        try {
            Date date = sdf_YYYY_MM_DD.parse(day);
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR_OF_DAY,1);
            return calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurrentDate();
    }

    public static Date parserYYYYMMDD_ADDMINUTE(String day) {
        try {
            Date date = sdf_YYYY_MM_DD.parse(day);
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE,1);
            return calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurrentDate();
    }

    public static String toYYYYMMDD(Date date) {
        try {
            return sdf_YYYY_MM_DD.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String toYYYYMM(Date date) {
        try {
            return sdf_YYYY_MM.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String toYYYYMMDDHHMMSS(Date date) {
        try {
            return sdf_YYYY_MM_DD_HH_MM_SS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Date parserYYYYMMDDHHMMSS(String str) {
        try {
            return sdf_YYYY_MM_DD_HH_MM_SS.parse(str);
        } catch (Exception e) {
            return parserYYYYMMDD(str);
        }
    }

    public static Date parserMMDDYYYY(String str) {
        try {
            return sdf_MM_DD_YYYY.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parserMMDDYYYYDefault(String str) {
        try {
            Date date = sdf_MM_DD_YYYY.parse(str);
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY,9);
            c.set(Calendar.MINUTE,9);
            c.set(Calendar.SECOND,9);
            return c.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toMMDDYYYY(Date date) {
        try {
            return sdf_MM_DD_YYYY.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String mmDDYYYYToyyyyMMDD(String dateStr) {
        try {
            Date date = parserMMDDYYYY(dateStr);
            String nstr = toYYYYMMDD(date);
            return nstr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static int getYear(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getMonth(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.MONTH)+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getWeekByYear(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.WEEK_OF_YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getWeekByYearCustom(Date date) {
        try {
            int day = getDayByYear(date);
            int weekNum = (day/7)+1;
            return weekNum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getWeekByMonth(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.WEEK_OF_MONTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getDayByYear(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DAY_OF_YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getDayByMonth(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getDayByWeek(Date date) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DAY_OF_WEEK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getQuarter(Date date) {
        try {
            int month = getMonth(date);
            return quarterArray[(month-1)/3];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int getChinaQuarter(Date date) {
        try {
            int month = getMonth(date);
            if (month==3 || month==4 || month==5)
                return chinaQuarterArray[0];
            if (month==6 || month==7 || month==8)
                return chinaQuarterArray[1];
            if (month==9 || month==10 || month==11)
                return chinaQuarterArray[2];
            if (month==12 || month==1 || month==2)
                return chinaQuarterArray[3];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Date getDateBettween(Date date, int startHour) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, startHour);
            calendar.set(Calendar.MINUTE, NumberTools.randomIn(60));
            return calendar.getTime();
        } catch (Exception e) {
        }
        return date;
    }

    public static Date getDateBettweenRandom(Date date, int startHour, int endHour) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, NumberTools.randomIn(startHour, endHour));
            calendar.set(Calendar.MINUTE, NumberTools.randomIn(60));
            return calendar.getTime();
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 将时间格式化为yyyyMMddHHmmss
     * @param date
     * @return
     */
    public static String getTimeYYYYMMDDHHMMSS(Date date) {
        try {
            return sdf_YYYYMMDDHHMMSS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
//        String str = "12/20/2016";
//        Date date = parserMMDDYYYYDefault(str);
//        System.out.println(date);
//        String nstr = toYYYYMMDD(date);
//        System.out.println(nstr);
//
//        String nss = mmDDYYYYToyyyyMMDD(str);
//        System.out.println(nss);
//
//        Date d = parserYYYYMMDD_ADDMINUTE(nss);
//        System.out.println(d);
//        Date date = parserYYYYMMDD("2015-12-29");
//        System.out.println(date);
//        int year = getYear(date);
//        int month = getMonth(date);
//        int week = getWeekByYearCustom(date);
//        int day = getDayByYear(date);
//        int quarter = getQuarter(date);
//        System.out.println(getDayByYear(date));
//        System.out.println(year+"-"+month+" "+week+" "+quarter);
//
//        System.out.println(getCurrentDayMax());
//
//        Date cur = new Date();
//        System.out.println(getCurrentDayMin(cur.getTime(), -5));

//        System.out.println(getCurrentDayOfWeek());
//
//        Date now = new Date();
//        System.out.println(getDateBettween(now, 4));
//        System.out.println(getDateBettweenRandom(now, 4, 9));
//
//        System.out.println(addCurrentDayHalfHour());

//        String time = "2017-07-11 00:00:00.0";
//        //time = "[startTime]";
//        Date d = parserYYYYMMDDHHMMSS(time);
//        System.out.println(d);
//
//        System.out.println(getCurrentDayMin().getTime());
//        System.out.println(getCurrentDayMax());
//
//        System.out.println(getTimeYYYYMMDDHHMMSS(d));

        int weekDay = 72;
        int curWeekDay = 32;
        //System.out.println(existWeek(weekDay, curWeekDay));

        //System.out.println(addCurrentDayHalfHour());

        //System.out.println(getCurrentRealWeek());

        System.out.println(getCurrentDayMin(-1));
        System.out.println(getCurrentDayMax(-1));

        System.out.println(getCurrentHour());
        System.out.println(getCurrentMinute());

        System.out.println(getCurrentYear());

        System.out.println(getCurrentWeekOfYear());
        System.out.println("今天星期:"+getCurrentWeek());

        System.out.println(existWeek(5, 2));

        long time = System.currentTimeMillis();
        System.out.println(addDayOneDay(time));

        System.out.println(getMonthFristDay(time));

        System.out.println(addTowHour(new Date()));
        System.out.println(toFileName(new Date(1527558927000l)));
    }

    public static String toFileName(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

}

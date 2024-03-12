package com.hut.kenny.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO 为使用java8中的时间类定义的工具方法
 * @Title: DateUtil
 * @Description:
 * @Author: 李铖
 * @Version: 1.0
 * @Date:  2022/4/16 13:36
 */
public class DateUtil {
    /**
     * 获取java.time.LocalDateTime对象的默认字符串格式形式
     * @param localDateTime
     * @return
     */
    public static String GetLocalDateTimeFromDefaultPattern(LocalDateTime localDateTime){
        //设置字符串形式时间的默认格式 - 字符串格式可以定义在常量类中
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static String GetLocalDateTimeFromDefaultPattern(Date date){
        return GetLocalDateTimeFromDefaultPattern(DateToLocalDateTime(date));
    }


    public static String GetLocalDateTimeFromDefaultPattern(Date date, String pattern){
        return GetLocalDateTimeFromDefaultPattern(DateToLocalDateTime(date), pattern);
    }



    public static String GetLocalDateTimeFromDefaultPattern(LocalDateTime localDateTime, String pattern){
        //设置字符串形式时间的默认格式 - 字符串格式可以定义在常量类中
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 将传入的长整型时间(1970-1-1到当前为止的毫秒数)，转型成java.time.LocalDateTime类型返回
     * @param time
     * @return
     */
    public static LocalDateTime TimeToLocalDateTime(long time){
        //根据传入的毫秒数，获得毫秒数所表示的一个时刻
        Instant instant = Instant.ofEpochMilli(time);
        //获取系统的默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }

    /**
     * 将传入的长整型时间(1970-1-1到当前为止的毫秒数)，转型成java.time.LocalDate类型返回
     * @param time
     * @return
     */
    public static LocalDate TimeToLocalDate(long time){
        LocalDateTime localDateTime = TimeToLocalDateTime(time);
        return localDateTime.toLocalDate();
    }

    /**
     * 将传入的java.util.Date类型转换为java.time.LocalDateTime类型返回
     * @param date
     * @return
     */
    public static LocalDateTime DateToLocalDateTime(Date date){
        return TimeToLocalDateTime(date.getTime());
    }

    /**
     * 将传入的java.util.Date类型转换为java.time.LocalDate类型返回
     * @param date
     * @return
     */
    public static LocalDate DateToLocalDate(Date date){
        return DateToLocalDateTime(date).toLocalDate();
    }

    public static Date LocalDateToDate(LocalDate localDate){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 返回每周 周一的日期
     * @param date
     * @return
     */
    public static LocalDate GetWeekStart(Date date){
        LocalDate localDate = DateToLocalDate(date);
        return localDate.with(DayOfWeek.MONDAY);    //返回周一的日期
    }

    /**
     * 返回两个日期之差
     * @param from
     * @param to
     * @return
     */
    public static long GetDateDiffOfDay(Date from, Date to) {
        LocalDate fromDate = DateToLocalDate(from);
        LocalDate toDate = DateToLocalDate(to);
        return toDate.until(fromDate, ChronoUnit.DAYS);
    }

    /**
     * 将某个日期转化成星期几
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 将date转化成 yyyy年MM月dd日 HH:mm:ss 周X
     * @return
     */
    public static String dateToEssayTime(Date date) {
        StringBuffer time = new StringBuffer();
        time.append(GetLocalDateTimeFromDefaultPattern(DateToLocalDateTime(date))).append(" ").append(dateToWeek(date));
        return time.toString();
    }

    /**
     * 日期判断
     * 如果当前日期小于传进来的日期就返回true
     * @param date2
     * @return
     */
    public static boolean compareDate(Date date2) {
        Date date1 = new Date();
        if (date1.compareTo(date2) > 0) {
            return false;
        } else if (date1.compareTo(date2) < 0) {
            return true;
        } else if (date1.compareTo(date2) == 0) {
            return true;
        }
        return false;
    }


    public static Date StringToDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        dateTime = simpleDateFormat.parse(date);
        return dateTime;
    }

    public static Date StringToDate2(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date dateTime = null;
        dateTime = simpleDateFormat.parse(date);
        return dateTime;
    }

    public static Date StringToDate3(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        dateTime = simpleDateFormat.parse(date);
        return dateTime;
    }
}

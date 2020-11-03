package com.luoyl.eureka_customer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TimeTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void localDateTest(){
        //获取当前日期
        LocalDate localDate = LocalDate.now();
        //构造指定年月日
        LocalDate date = LocalDate.of(2020, 10, 16);
        //获取年月日周几
        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth = localDate.getDayOfMonth();
        int dayOfMonth1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

        System.out.println("当前日期："+localDate);
        System.out.println("构造日期："+date);
        System.out.println("获取到的年份："+year+","+year1);
        System.out.println("获取到的月份："+month+","+month1);
        System.out.println("获取到的日："+dayOfMonth+","+dayOfMonth1);
        System.out.println("获取到的周几："+dayOfWeek+","+dayOfWeek1);

    }


    @Test
    public void localDateTimeTest(){
        //获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        //构造指定日期时间
        LocalDateTime dateTime = LocalDateTime.of(2020, 10, 15, 9, 30);
        //获取年份、月份、日期同LocalDate
        //获取LocalDate
        LocalDate localDate = localDateTime.toLocalDate();
        //获取时间
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println("当前日期时间："+localDateTime);
        System.out.println("构造指定日期时间："+dateTime);
        System.out.println("localDate："+localDate);
        System.out.println("localTime："+localTime);

        //获取秒数
        Instant instant = Instant.now();
        long epochSecond = instant.getEpochSecond();
        //获取毫秒数
        long l = instant.toEpochMilli();
        System.out.println("秒数："+epochSecond);
        System.out.println("毫秒数："+l);

        //格式化时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println("格式化时间："+format);

        //增加、减少年份、月份、日期
        LocalDateTime days = localDateTime.plusDays(1);
        LocalDateTime hours = localDateTime.plusHours(2);
        LocalDateTime months = localDateTime.plusMonths(1);
        LocalDateTime years = localDateTime.plusYears(1);
        logger.warn("加一天："+days);
        logger.warn("加两小时："+hours);
        logger.warn("加一个月："+months);
        logger.warn("加一年："+years);

    }

    @Test
    public void test(){
        int i = 0;
        System.out.println(++i);
        //
        // System.out.println(i++);
    }

}

/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.helper;


import com.link510.softgateway.core.log.ILog;
import com.link510.softgateway.core.log.ILogService;
import com.link510.softgateway.core.log.ILog;
import com.link510.softgateway.core.log.ILogService;
import org.junit.Test;

import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cqnews on 2017/3/20.
 */
public class TypeHelper {


    private static ILog logger = ILogService.getLog(DateHelper.class);

    /// <summary>
    /// 将string类型转换成int类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static Integer StringToInt(String s) {
        return StringToInt(s, 0);
    }

    /// <summary>
    /// 将string类型转换成int类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static Integer StringToInt(Object s, Integer defaultValue) {
        try {

            if (s != null && String.valueOf(s).trim().length() > 0)
                return Integer.parseInt(s.toString());
            else
                return defaultValue;

        } catch (Exception e) {
            logger.error("ERROR" + e.toString());
            return defaultValue;
        }
    }

    public static Integer ObjectToInt(Object o) {

        return ObjectToInt(o, 0);
    }

    public static Integer ObjectToInt(Object o, Integer defaultValue) {
        try {
            return (Integer ) o;
        } catch (Exception e) {
            return defaultValue;
        }
    }


    /// <summary>
    /// 将int类型转换成string类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static String IntToString(Integer s) {
        return IntToString(s, "0");
    }

    /// <summary>
    /// 将string类型转换成int类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static String IntToString(Object s, String defaultValue) {
        try {

            if (s != null)
                return String.valueOf(s.toString());

            else
                return defaultValue;

        } catch (Exception e) {
            logger.error("ERROR" + e.toString());
            return defaultValue;
        }
    }

    /**
     * char 转字符串
     *
     * @param c
     * @return
     */
    public static String CharToString(char c) {
        try {
            return String.valueOf(c);
        } catch (Exception e) {
            return "";
        }
    }


    /// <summary>
    /// 将int类型转换成string类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static String LongToString(long s) {
        return LongToString(s, "0");
    }

    /// <summary>
    /// 将string类型转换成int类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static String LongToString(Object s, String defaultValue) {
        try {

            if (s != null)
                return String.valueOf(s.toString());

            else
                return defaultValue;

        } catch (Exception e) {
            logger.error("ERROR" + e.toString());
            return defaultValue;
        }
    }

    /// <summary>
    /// 将string类型转换成double类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static double StringToDouble(String s) {
        return StringToDouble(s, 0);
    }

    /// <summary>
    /// 将string类型转换成double类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static double StringToDouble(Object s, Integer defaultValue) {
        try {

            if (s != null)
                return Double.parseDouble(s.toString());
            else
                return defaultValue;

        } catch (Exception e) {
            logger.error("ERROR" + e.toString());
            return defaultValue;
        }
    }


    /// <summary>
    /// 将string类型转换成double类型
    /// </summary>
    /// <param name="s">目标字符串</param>
    /// <returns></returns>
    public static String DoubleToString(double s) {
        return DoubleToString(s, "");
    }

    public static String DoubleToString(Object s, String defaultValue) {

        try {

            if (s != null)
                return String.valueOf(s.toString());

            else
                return defaultValue;

        } catch (Exception e) {
            logger.error("ERROR" + e.toString());
            return defaultValue;
        }

    }


    public static Integer LongToInt(Long value) {
        return LongToInt(value, 0);
    }

    public static Integer LongToInt(Long value, Integer defaultValue) {
        try {
            return new Long(value).intValue();
        } catch (Exception e) {

            return defaultValue;
        }
    }


    /**
     * TimestampToDate 转date
     *
     * @param timestamp
     * @return
     */
    public static Date TimestampToDate(Timestamp timestamp) {

        Date date = new Date();
        try {
            date = timestamp;

        } catch (Exception e) {

        }
        return date;
    }

    /**
     * DateToTimestamp 转Timestamp
     *
     * @param date
     * @return
     */
    public static Timestamp DateToTimestamp(Date date) {

        Timestamp timestamp = DateHelper.getTimestamp(date);
        return timestamp;
    }


    /**
     * StringToDate 字符转date类型
     *
     * @param s
     * @return
     */
    public static Date StringToDate(String s) {

        if (s.isEmpty())
            return null;

        s = s.replace("/", "-").replace("：", ":");

        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            date = sdf.parse(s);

        } catch (Exception e) {
        }

        return date;
    }

    /**
     * StringToDate 字符转date类型
     *
     * @param s
     * @return
     */
    public static Timestamp StringToTimestamp(String s) {

        if (s.isEmpty())
            return null;

        s = s.replace("/", "-").replace("：", ":");


        Timestamp ts;

        try {

            ts = Timestamp.valueOf(s);

        } catch (Exception e) {
            ts = DateHelper.getTimestamp();
        }

        return ts;
    }


    /**
     * 字符串转输入流
     *
     * @param str
     * @return
     */
    InputStream String2InputStream(String str) {
        ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
        return stream;
    }

    /**
     * 输入流转字符串
     *
     * @param is
     * @return
     * @throws IOException
     */
    String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    /**
     *
     */
    @Test
    public void Test() {

        Timestamp ts = StringToTimestamp("2020-12-30 00:00:00");

        System.out.println(ts);

    }

}
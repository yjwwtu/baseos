/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.helper;

import java.io.*;

/**
 * IO帮助类
 * Created by cqnews on 2017/4/7.
 */
public class IOHelper {


    /**
     * 获取当前文件的根路径
     *
     * @param path
     * @return
     */
    public static String GetRootPath(String path) {

        String classPath=GetMapPath(path);

        classPath=classPath.replace("WEB-INF\\", ""); //去掉WEB-INF\

        return classPath;

    }

    /**
     * 获取当前文件的绝对路径
     *
     * @param path 文件名
     * @return
     */
    public static String GetMapPath(String path) {
        //file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/



        String filepath = Thread.currentThread().getContextClassLoader().getResource("").toString();

        filepath = filepath.replace('/', '\\'); // 将/换成\
        filepath = filepath.replace("file:", ""); //去掉file:
        filepath = filepath.replace("classes\\", ""); //去掉class\
        filepath = filepath.replace("%20", " ");
        filepath = filepath.substring(1); //去掉第一个\,如 \D:\JavaWeb...
        //System.out.println(path);
        return filepath + path;
    }

    /**
     * 获取当前文件的绝对路径
     *
     * @return
     */
    public static String GetMapPath() {

        return GetMapPath("");
    }


    /**
     * 字符串转 --> InputStream
     *
     * @param str 字符串
     * @return
     */
    public static InputStream StringToInputStream(String str) {
        ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
        return stream;
    }

    /**
     * InputStream --> 字符串
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String InputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }


}

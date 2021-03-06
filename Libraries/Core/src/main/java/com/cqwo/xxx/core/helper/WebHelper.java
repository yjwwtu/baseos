/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.helper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cqnews
 * @date 2017/12/7
 */
public class WebHelper {


    /**
     * 浏览器列表
     */
    private static String[] browserlist = new String[]{"ie", "chrome", "mozilla", "netscape", "firefox", "opera", "konqueror"};


    /**
     * region Http封装
     */
    public WebHelper() {

    }


    /**
     * \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
     * 字符串在编译时会被转码一次,所以是 "\\b"
     * \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
     */
    static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    static String _tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";


    private static Pattern detectphoneregex = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);

    private static Pattern detecttableregex = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);

    private static Pattern detectiphoneregex = Pattern.compile("iphone|Mac", Pattern.CASE_INSENSITIVE);

    private static Pattern detectwechatregex = Pattern.compile("MicroMessenger|micromessenger", Pattern.CASE_INSENSITIVE);

    //region 编码

    /**
     * HTML解码
     *
     * @param s 编码串
     * @return
     */
    public static String htmlDecode(String s) {
        return StringEscapeUtils.escapeHtml4(s);
    }

    /**
     * HTML编码
     *
     * @param s
     * @return
     */
    public static String htmlEncode(String s) {
        return StringEscapeUtils.unescapeHtml4(s);
    }

    /**
     * URL解码
     *
     * @param s s
     * @return String
     */
    public static String urlDecode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


    /**
     * URL编码
     *
     * @param s s
     * @return String
     */
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    //endregion

    //region Cookies操作封装
    /**
     * 设置cookie有效期，根据需要自定义[本系统设置为30天]
     */
    private final static Integer COOKIE_MAX_AGE = 1000 * 60 * 60 * 24 * 30;

    /**
     * @param cookie
     * @desc 删除指定Cookie
     */
    public static void removeCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * @param cookieName
     * @desc 删除指定Cookie
     */
    public static void removeCookie(HttpServletResponse response, String cookieName) {
        setCookie(response, cookieName, "", 1);
    }

    /**
     * @param cookie
     * @param domain
     * @desc 删除指定Cookie
     */
    public static void removeCookie(HttpServletResponse response, Cookie cookie, String domain) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setDomain(domain);
            response.addCookie(cookie);
        }
    }

    /**
     * @param name
     * @return
     * @desc 根据Cookie名称得到Cookie的值，没有返回Null
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * @param name
     * @desc 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || name == null || name.length() == 0) {
            return null;
        }
        Cookie cookie = null;
        for (Integer i = 0; i < cookies.length; i++) {
            if (!cookies[i].getName().equals(name)) {
                continue;
            }
            cookie = cookies[i];
            if (request.getServerName().equals(cookie.getDomain())) {
                break;
            }
        }

        return cookie;
    }

    /**
     * @param name
     * @param value
     * @desc 添加一条新的Cookie信息，默认有效时间为一个月
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, COOKIE_MAX_AGE);
    }

    /**
     * @param name
     * @param value
     * @param expire
     * @desc 添加一条新的Cookie信息，可以设置其最长有效时间(单位：秒)
     */
    public static void setCookie(HttpServletResponse response, String name, String value, Integer expire) {
        if (value == null) {
            value = "";
        }
        Cookie cookie = new Cookie(name, value);
        if (expire != 0) {
            cookie.setMaxAge(expire);
        } else {
            cookie.setMaxAge(COOKIE_MAX_AGE);
        }
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    //endregion

    //region 客户端信息

    /**
     * 是否是get请求
     *
     * @return
     */
    public static boolean IsGet(HttpServletRequest request) {
        return "GET".equals(request.getMethod());
    }

    /**
     * 是否是get请求
     *
     * @return
     */
    public static boolean IsPost(HttpServletRequest request) {
        return "POST".equals(request.getMethod());
    }

    /**
     * 是否是Ajax请求
     *
     * @return
     */
    public static boolean IsAjax(HttpServletRequest request) {
        return "text/html;type=ajax".equals(request.getHeader("Accept"));
    }


    /**
     * 获得上次请求的url
     *
     * @return
     */
    public static String getUrlReferrer(HttpServletRequest request) {

        String uri = request.getHeader("Referer");
        if (uri == null) {
            return "";
        }
        return uri;
    }

    /**
     * 获得请求的主机部分
     *
     * @return
     */
    public static String getHost(HttpServletRequest request) {
        return request.getRemoteHost();
    }


    /**
     * 获得请求的原始url
     *
     * @return
     */
    public static String getRawUrl(HttpServletRequest request) {
        return request.getRequestURI().toString();
    }

    /**
     * 获得请求的ip
     *
     * @return
     */
    public static String getIP(HttpServletRequest request) {

        System.out.println(request.getRemoteAddr().toString());

        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if (forwarded != null) {
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }


    /// <summary>
    /// 获得请求的浏览器类型
    /// </summary>
    /// <returns></returns>

    /**
     * 获得请求的浏览器类型
     *
     * @return
     */
    public static String GetBrowserType(HttpServletRequest request) {
        String type = request.getHeader("User-Agent");
        if (type == null || "unknown".equals(type) || "".equals(type)) {
            return "未知";
        }
        return type.toLowerCase();
    }


    /**
     * 检测是否手机访问
     *
     * @param request request
     * @return
     */
    public static boolean IsMobile(HttpServletRequest request) {

        String userAgent = request.getHeader("User-Agent");

        if (userAgent == null) {
            return false;
        }


        Matcher matcherPhone = detectiphoneregex.matcher(userAgent);
        Matcher matcherTable = detecttableregex.matcher(userAgent);

        if (matcherPhone.find() || matcherTable.find()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 检测是否手机微信访问
     *
     * @param request request
     * @return
     */
    public static boolean IsWechat(HttpServletRequest request) {

        String userAgent = request.getHeader("User-Agent");

        if (userAgent == null) {
            return false;
        }


        Matcher matcherWechat = detectwechatregex.matcher(userAgent);

        if (matcherWechat.find()) {
            return true;
        } else {
            return false;
        }


    }

    @Test
    public void Test() {
        String userAgent = "Mozilla/5.0 (Linux; U; Android 7.1.1; zh-CN; Nexus 6 Build/N6F27E) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 UCBrowser/11.8.1.1043 Mobile Safari/537.36 AliApp(TUnionSDK/0.1.20)";
        Matcher matcherWechat = detectphoneregex.matcher(userAgent);

        if (matcherWechat.find()) {
            System.out.println("是手机访问");
        } else {
            System.out.println("不是手机访问");
        }
    }

    /**
     * 页面跳转封装
     *
     * @param response
     * @param url
     * @return
     */
    public static boolean sendRedirect(HttpServletResponse response, String url) {

        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    //endregion


    //region 封装取值


    /**
     * 获得查询字符串中的值
     *
     * @param request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return String
     */
    public static String getQueryString(HttpServletRequest request, String key, String defaultValue) {
        String s = defaultValue;
        try {
            s = request.getParameter(key);
            if (StringHelper.IsNullOrWhiteSpace(s)) {
                s = defaultValue;
            }

        } catch (Exception e) {

        }

        return s;
    }

    /**
     * 获得查询字符串中的值
     *
     * @param request request
     * @param key     键
     * @return String
     */
    public static String getQueryString(HttpServletRequest request, String key) {
        return getQueryString(request, key, "");
    }

    /**
     * 获得查询字符串中的值
     *
     * @param request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return Integer
     */
    public static Integer getQueryInt(HttpServletRequest request, String key, Integer defaultValue) {
        return TypeHelper.StringToInt(request.getParameter(key), defaultValue);
    }

    /**
     * 获得查询字符串中的值
     *
     * @param request request
     * @param key     键
     * @return Integer
     */
    public static Integer getQueryInt(HttpServletRequest request, String key) {
        return getQueryInt(request, key, 0);
    }


    /**
     * 获得表单中的值
     *
     * @param request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return String
     */
    public static String getFormString(HttpServletRequest request, String key, String defaultValue) {
        String value = request.getParameter(key);
        if (!StringHelper.IsNullOrWhiteSpace(value)) {
            return value;
        } else {
            return defaultValue;
        }
    }


    /**
     * 获得表单中的值
     *
     * @param request request
     * @param key     键
     * @return String
     */
    public static String getFormString(HttpServletRequest request, String key) {
        return getFormString(request, key, "");
    }

    /**
     * 获得表单中的值
     *
     * @param request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return Integer
     */
    public static Integer getFormInt(HttpServletRequest request, String key, Integer defaultValue) {
        return TypeHelper.StringToInt(request.getParameter(key), defaultValue);
    }

    /**
     * 获得表单中的值
     *
     * @param request request
     * @param key     键
     * @return Integer
     */
    public static Integer getFormInt(HttpServletRequest request, String key) {
        return getFormInt(request, key, 0);
    }

    /**
     * 获得请求中的值
     *
     * @param request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return String
     */
    public static String getRequestString(HttpServletRequest request, String key, String defaultValue) {

        String s = (String) request.getAttribute(key);
        if (!StringHelper.IsNullOrWhiteSpace(s)) {
            return s;
        } else {
            return defaultValue;
        }
    }

    /**
     * 获得请求中的值
     *
     * @param request request
     * @param key     键
     * @return String
     */
    public static String getRequestString(HttpServletRequest request, String key) {
        return getRequestString(request, key, "");
    }


    /**
     * 获得请求中的值
     *
     * @param request      request      request
     * @param key          键
     * @param defaultValue 默认值
     * @return Integer
     */
    public static Integer getRequestInt(HttpServletRequest request, String key, Integer defaultValue) {

        Integer i = defaultValue;

        try {
            i = (Integer ) request.getAttribute(key);
        } catch (Exception e) {

        }
        return i;
    }

    /**
     * 获得请求中的值
     *
     * @param request request
     * @param key     键
     * @return Integer
     */
    public static Integer getRequestInt(HttpServletRequest request, String key) {

        return getRequestInt(request, key, 0);
    }


    /**
     * 获得请求的url
     *
     * @param request request
     * @return
     */
    public static String getUrl(HttpServletRequest request) {
        return request.getRequestURI();
    }


    /**
     * 获得请求的浏览器类型
     *
     * @param request request
     * @return
     */
    public static String getBrowserType(HttpServletRequest request) {
        String type = request.getAuthType();
        if (StringHelper.IsNullOrWhiteSpace(type) || "unknown".equals(type)) {
            return "未知";
        }

        return type.toLowerCase();
    }

    /**
     * 获得请求的浏览器名称
     *
     * @param request request
     * @return
     */
    public static String getBrowserName(HttpServletRequest request) {
        String name = request.getHeader("User-Agent");
        if (StringHelper.IsNullOrEmpty(name) || "unknown".equals(name)) {
            return "未知";
        }

        return name.toLowerCase();
    }


    /**
     * 获得请求的浏览器版本
     *
     * @param request request
     * @return
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        String version = request.getHeader("User-Agent");
        if (StringHelper.IsNullOrEmpty(version) || "unknown".equals(version)) {
            return "未知";
        }

        return version;
    }

    /**
     * 获得请求客户端的操作系统类型
     *
     * @param request request
     * @return
     */
    public static String getOSType(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "未知";
        }

        String type = null;
        if (userAgent.contains("NT 6.1")) {
            type = "Windows 7";
        } else if (userAgent.contains("NT 5.1")) {
            type = "Windows XP";
        } else if (userAgent.contains("NT 6.2")) {
            type = "Windows 8";
        } else if (userAgent.contains("android")) {
            type = "Android";
        } else if (userAgent.contains("iphone")) {
            type = "IPhone";
        } else if (userAgent.contains("Mac")) {
            type = "Mac";
        } else if (userAgent.contains("NT 6.0")) {
            type = "Windows Vista";
        } else if (userAgent.contains("NT 5.2")) {
            type = "Windows 2003";
        } else if (userAgent.contains("NT 5.0")) {
            type = "Windows 2000";
        } else if (userAgent.contains("98")) {
            type = "Windows 98";
        } else if (userAgent.contains("95")) {
            type = "Windows 95";
        } else if (userAgent.contains("Me")) {
            type = "Windows Me";
        } else if (userAgent.contains("NT 4")) {
            type = "Windows NT4";
        } else if (userAgent.contains("Unix")) {
            type = "UNIX";
        } else if (userAgent.contains("Linux")) {
            type = "Linux";
        } else if (userAgent.contains("SunOS")) {
            type = "SunOS";
        } else {
            type = "未知";
        }

        return type;
    }


    /**
     * 判断是否是浏览器请求
     *
     * @param request request
     * @return
     */
    public static boolean isBrowser(HttpServletRequest request) {
        String name = getBrowserName(request);
        for (String item : browserlist) {
            if (name.contains(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取数据验证头
     *
     * @param request request
     * @return String
     */
    public static String getApiTokenHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-Token");
        } catch (Exception e) {

            return "";
        }
    }

    /**
     * 获取数据验证头
     *
     * @param request request
     * @return String
     */
    public static String getApiOpenIdHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-OpenId");
        } catch (Exception e) {
            return "";
        }
    }

    /***
     * 获取openid
     * @param request request
     * @return
     */
    public static String getApiOpenIdHeader(ServletRequest request) {
        try {
            return request.getParameter("openId");
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 获取APIKEY验证头
     * @param request request
     * @return String
     */
    public static String getApiKeyHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-ApiKey");
        } catch (Exception e) {

            return "";
        }
    }

    /**
     * 获取数据验证头
     * @param request request
     * @return String
     */
    public static String getApiSecretHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-ApiSecret");
        } catch (Exception e) {

            return "";
        }
    }

    /**
     * 获取数据OPENID头
     * @param request request
     * @return String
     */
    public static String getOpenIdHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-OpenId");
        } catch (Exception e) {

            return "";
        }
    }

    /**
     * 获取SessionId
     * @param request request
     * @return String
     */
    public static String getSessionIdHeader(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-SessionId");
        } catch (Exception e) {
            return "";
        }

    }

    public static String getUserAgent(HttpServletRequest request) {
        try {
            return request.getHeader("X-CWMAPI-UserAgent");

        } catch (Exception e) {

            return "";
        }
    }

    /**
     * 处理url
     *
     * @param url
     * @return
     */
    public static String disposeUrl(String url) {

        if (url.contains("https://") || url.contains("http://")) {

            url = url.replaceAll("http:/", "http://");
            url = url.replaceAll("https:/", "https://");

            url = url.replaceAll("//", "/");


            url = url.replaceAll("http://https://", "https://");
            url = url.replaceAll("https://http://", "https://");
            url = url.replaceAll("http://http://", "https://");

        } else {
            url = "http://" + url;
        }
        return url;
    }


    /**
     * ip转int
     *
     * @param ip
     * @return
     */
    public static Integer ipToInteger(String ip) {
        String[] ips = ip.split("\\.");
        Integer ipFour = 0;
        //因为每个位置最大255，刚好在2进制里表示8位
        for (String ip4 : ips) {
            Integer ip4a = Integer.parseInt(ip4);
            //这里应该用+也可以,但是位运算更快
            ipFour = (ipFour << 8) | ip4a;
        }
        return ipFour;
    }

    //ip = 3232235778

    /**
     * int转ip
     * @param ip ip
     * @return ip
     */
    public static String intToIp(Integer ip) {
        StringBuilder result = new StringBuilder(15);

        for (Integer i = 0; i < 4; i++) {

            result.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }

            ip = ip >> 8;
        }
        return result.toString();
    }

    //ip = 3232235778

    /**
     * longtoip
     * @param ip ip
     * @return
     */
    public String longToIp2(Integer ip) {

        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }

    @Test
    public void test2() {


        String s = "https://http://www.cq187.cn//wechat/notify.html";
        System.out.println("s:" + s);
        s = disposeUrl(s);
        System.out.println("s:" + s);
    }

    //endregion

}

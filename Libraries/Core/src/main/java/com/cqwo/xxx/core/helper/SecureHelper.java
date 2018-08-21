/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.helper;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 * 安装帮助类
 * Created by cqnews on 2017/12/12.
 */
public class SecureHelper {

    private static final String _base64regex="[A-Za-z0-9\\=\\/\\+]";


    /**
     * AES加密
     * @param encryptStr
     * @param secretkey
     * @return
     */
    public static String aesEncrypt(String encryptStr, String secretkey) {

        String returnStr="";
        try {
            returnStr=AESHelper.encode(encryptStr);
        } catch (Exception e) {

        }

        return "";
    }

    /**
     * AES解密
     *
     * @param decryptStr
     * @param secretkey
     * @return
     */
    public static String aesDecrypt(String decryptStr, String secretkey) {

        String returnStr="";
        try {
            returnStr=AESHelper.decode(decryptStr);
        } catch (Exception e) {
        }

        return returnStr;
    }


    /**
     * Md5 加密
     *
     * @param pwd 原始密码
     * @return
     */
    public static String md5(String pwd) {
        try {
            //创建加密对象
            MessageDigest digest=MessageDigest.getInstance("md5");
            // 调用加密对象的方法，加密的动作已经完成
            byte[] bytes=digest.digest(pwd.getBytes());
            StringBuilder hexString= new StringBuilder();
            for (byte b : bytes) {
                Integer temp=b & 255;
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString.append("0").append(Integer.toHexString(temp));
                } else {
                    hexString.append(Integer.toHexString(temp));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    /**
     * sha1算法
     *
     * @param s
     * @return
     */
    public static String sha1(String s) {

        return DigestUtils.sha1Hex(s);
    }


    /// <summary>
    /// 判断是否是Base64字符串
    /// </summary>
    /// <returns></returns>
    public static boolean isBase64String(String str) {

        if (str != null) {
            return Pattern.matches(_base64regex, str);
        }
        return true;
    }



}

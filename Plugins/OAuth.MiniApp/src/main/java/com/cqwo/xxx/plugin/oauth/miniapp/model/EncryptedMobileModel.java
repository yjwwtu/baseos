package com.cqwo.xxx.plugin.oauth.miniapp.model;

import javax.validation.constraints.NotBlank;

public class EncryptedMobileModel {


    /**
     * 包括敏感数据在内的完整用户信息的加密数据
     */
    @NotBlank(message = "加密数据不能为空")
    private String encryptedData = "";

    /**
     * 加密算法的初始向量
     */
    @NotBlank(message = "初始向量不能为空")
    private String iv = "";


    public EncryptedMobileModel() {
    }

    public EncryptedMobileModel(@NotBlank(message = "加密数据不能为空") String encryptedData, @NotBlank(message = "初始向量不能为空") String iv) {
        this.encryptedData = encryptedData;
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "EncryptedMobileModel{" +
                "encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                '}';
    }
}

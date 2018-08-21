package com.cqwo.xxx.core.domain.users;

import java.io.Serializable;

public class UserTokenInfo implements Serializable {


    private Integer uid = -1;

    private String openId = "";

    private String apikey = "";


    public UserTokenInfo() {
    }

    public UserTokenInfo(Integer uid, String openId) {
        this.uid = uid;
        this.openId = openId;
    }

    public UserTokenInfo(Integer uid, String openId, String apikey) {
        this.uid = uid;
        this.openId = openId;
        this.apikey = apikey;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @Override
    public String toString() {
        return "UserTokenInfo{" +
                "uid=" + uid +
                ", openId='" + openId + '\'' +
                ", apikey='" + apikey + '\'' +
                '}';
    }
}

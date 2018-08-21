package com.cqwo.xxx.web.api.model;


import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.users.UserRankInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.users.UserRankInfo;

/**
 * 用户中心首页
 */
public class UCenterHomeModel {

    /**
     * 用户uid
     */
    private Integer uid;

    /**
     * 用户信息
     */
    private PartUserInfo userInfo;


    /**
     * 用户分组
     */
    private UserRankInfo userRankInfo;

    public UCenterHomeModel() {
    }

    public UCenterHomeModel(Integer uid, PartUserInfo userInfo, UserRankInfo userRankInfo) {
        this.uid = uid;
        this.userInfo = userInfo;
        this.userRankInfo = userRankInfo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public PartUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(PartUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserRankInfo getUserRankInfo() {
        return userRankInfo;
    }

    public void setUserRankInfo(UserRankInfo userRankInfo) {
        this.userRankInfo = userRankInfo;
    }

    @Override
    public String toString() {
        return "UCenterHomeModel{" +
                "uid=" + uid +
                ", userInfo=" + userInfo +
                ", userRankInfo=" + userRankInfo +
                '}';
    }
}

package com.link510.softgateway.web.admin.model;

import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.web.framework.model.PageModel;

import java.util.List;

public class UserListModel {


    /**
     * 用户uid
     */
    private Integer uid = 0;

    /**
     * 用户昵称
     */
    private String nickName = "";

    /**
     * 手机号码
     */
    private String mobile = "";

    /**
     * 用户列表
     */
    private List<PartUserInfo> userInfoList;

    /**
     * 分页模型
     */
    private PageModel pageModel;

    public UserListModel() {
    }

    public UserListModel(List<PartUserInfo> userInfoList, PageModel pageModel) {
        this.userInfoList = userInfoList;
        this.pageModel = pageModel;
    }

    public UserListModel(Integer uid, String nickName, String mobile) {
        this.uid = uid;
        this.nickName = nickName;
        this.mobile = mobile;
    }

    public UserListModel(Integer uid, String nickName, String mobile, List<PartUserInfo> userInfoList, PageModel pageModel) {
        this.uid = uid;
        this.nickName = nickName;
        this.mobile = mobile;
        this.userInfoList = userInfoList;
        this.pageModel = pageModel;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<PartUserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<PartUserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "UserListModel{" +
                "userInfoList=" + userInfoList +
                ", pageModel=" + pageModel +
                '}';
    }
}

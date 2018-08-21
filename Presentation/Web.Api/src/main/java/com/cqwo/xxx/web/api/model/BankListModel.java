/*
 *
 *  *
 *  *  * Copyright (C) 2018.
 *  *  * 用于JAVA项目开发
 *  *  * 重庆青沃科技有限公司 版权所有
 *  *  * Copyright (C)  2018.  CqingWo Systems Incorporated. All rights reserved.
 *  *
 *
 */

package com.cqwo.xxx.web.api.model;

import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.web.framework.model.SimplePageModel;

import java.util.List;


/**
 * 银行流水列表模型
 */
public class BankListModel {

    PartUserInfo userInfo;

    /**
     * 银行流水列表
     */
    List<BankRollInfo> bankRollInfoList;

    /**
     * 分页模型
     */
    SimplePageModel pageModel;

    public BankListModel() {
    }

    public BankListModel(PartUserInfo userInfo, List<BankRollInfo> bankRollInfoList, SimplePageModel pageModel) {
        this.userInfo = userInfo;
        this.bankRollInfoList = bankRollInfoList;
        this.pageModel = pageModel;
    }

    public PartUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(PartUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<BankRollInfo> getBankRollInfoList() {
        return bankRollInfoList;
    }

    public void setBankRollInfoList(List<BankRollInfo> bankRollInfoList) {
        this.bankRollInfoList = bankRollInfoList;
    }

    public SimplePageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(SimplePageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "BankListModel{" +
                "userInfo=" + userInfo +
                ", bankRollInfoList=" + bankRollInfoList +
                ", pageModel=" + pageModel +
                '}';
    }
}

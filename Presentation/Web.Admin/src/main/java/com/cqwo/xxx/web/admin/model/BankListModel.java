package com.cqwo.xxx.web.admin.model;

import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.web.framework.model.PageModel;

import java.util.List;


/**
 * 财务列表模型
 */
public class BankListModel {


    private Integer state = 0;

    private List<BankRollInfo> bankRollInfoList;

    private PageModel pageModel;


    public BankListModel(Integer state, List<BankRollInfo> bankRollInfoList, PageModel pageModel) {
        this.state = state;
        this.bankRollInfoList = bankRollInfoList;
        this.pageModel = pageModel;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<BankRollInfo> getBankRollInfoList() {
        return bankRollInfoList;
    }

    public void setBankRollInfoList(List<BankRollInfo> bankRollInfoList) {
        this.bankRollInfoList = bankRollInfoList;
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "BankListModel{" +
                "bankRollInfoList=" + bankRollInfoList +
                ", pageModel=" + pageModel +
                '}';
    }
}

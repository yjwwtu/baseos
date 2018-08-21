package com.cqwo.xxx.web.admin.model;


import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 财务审核
 */
public class BankExamineModel {

    /**
     * 财务id
     */
    @NotNull(message = "流水不正确")
    @Range(min = 1, message = "流水不正确")
    private Integer id = 0;

    /**
     * 财务描述
     */
    @NotBlank(message = "描述不能为空")
    @Length(min = 5, max = 150, message = "不能少于5个字符")
    private String actionDes = "";

    /**
     * 用户信息
     */
    PartUserInfo userInfo;

    /**
     * 财务详情
     */
    private BankRollInfo bankRollInfo;

    public BankExamineModel() {
    }

    public BankExamineModel(Integer id, String actionDes) {
        this.id = id;
        this.actionDes = actionDes;
    }

    public BankExamineModel(Integer id, PartUserInfo userInfo, BankRollInfo bankRollInfo) {
        this.id = id;
        this.bankRollInfo = bankRollInfo;
    }


    public BankExamineModel(Integer id, String actionDes, BankRollInfo bankRollInfo) {
        this.id = id;
        this.actionDes = actionDes;
        this.bankRollInfo = bankRollInfo;
    }

    public BankExamineModel(@NotNull(message = "流水不正确") @Range(min = 1, message = "流水不正确") Integer id, @NotBlank(message = "描述不能为空") @Length(min = 5, max = 150, message = "不能少于5个字符") String actionDes, PartUserInfo userInfo, BankRollInfo bankRollInfo) {
        this.id = id;
        this.actionDes = actionDes;
        this.userInfo = userInfo;
        this.bankRollInfo = bankRollInfo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionDes() {
        return actionDes;
    }

    public void setActionDes(String actionDes) {
        this.actionDes = actionDes;
    }

    public PartUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(PartUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public BankRollInfo getBankRollInfo() {
        return bankRollInfo;
    }

    public void setBankRollInfo(BankRollInfo bankRollInfo) {
        this.bankRollInfo = bankRollInfo;
    }

    @Override
    public String toString() {
        return "BankExamineModel{" +
                "id=" + id +
                ", actionDes='" + actionDes + '\'' +
                ", userInfo=" + userInfo +
                ", bankRollInfo=" + bankRollInfo +
                '}';
    }
}

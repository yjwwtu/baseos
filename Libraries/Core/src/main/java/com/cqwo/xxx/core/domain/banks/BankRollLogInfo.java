package com.cqwo.xxx.core.domain.banks;

import javax.persistence.*;
import java.io.Serializable;

//流水日志记录
@Entity
@Table(name = "w_bankroll_logs")
public class BankRollLogInfo implements Serializable {


    private static final long serialVersionUID = -2895655417418359686L;
    /**
     * 日志id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logid")
    private Integer logId = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;

    /**
     * 流水id
     **/
    @Column(name = "bankrollid", nullable = false)
    private Integer bankRollId = 0;

    /**
     * 涉及金额
     **/
    @Column(name = "money", nullable = false)
    private double money = 0;

    /**
     * 操作代码
     **/
    @Column(name = "code", nullable = false)
    private Integer code = 0;

    /**
     * 动作代码
     **/
    @Column(name = "actioncode", nullable = false)
    private Integer actionCode = 0;

    /**
     * 动作时间
     **/
    @Column(name = "actiontime", nullable = false)
    private Integer actionTime = 0;

    /**
     * 动作描述
     **/
    @Column(name = "actiondes", nullable = false)
    private String actionDes = "";

    /**
     * 操作人
     **/
    @Column(name = "operator", nullable = false)
    private int operator = 0;

    public BankRollLogInfo() {
    }


    public BankRollLogInfo(Integer uid, Integer bankRollId, double money, Integer code, Integer actionCode, Integer actionTime, String actionDes, int operator) {
        this.uid = uid;
        this.bankRollId = bankRollId;
        this.money = money;
        this.code = code;
        this.actionCode = actionCode;
        this.actionTime = actionTime;
        this.actionDes = actionDes;
        this.operator = operator;
    }

    public BankRollLogInfo(BankRollInfo bankinfo) {
        this.uid = bankinfo.getUid();
        this.bankRollId = bankinfo.getId();
        this.money = bankinfo.getMoney();
        this.code = bankinfo.getState();
        this.actionCode = bankinfo.getBankAction();
        this.actionTime = bankinfo.getUpdateTime();
        this.actionDes = bankinfo.getDescription();
        this.operator = bankinfo.getOperator();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBankRollId() {
        return bankRollId;
    }

    public void setBankRollId(Integer bankRollId) {
        this.bankRollId = bankRollId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getActionCode() {
        return actionCode;
    }

    public void setActionCode(Integer actionCode) {
        this.actionCode = actionCode;
    }

    public Integer getActionTime() {
        return actionTime;
    }

    public void setActionTime(Integer actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionDes() {
        return actionDes;
    }

    public void setActionDes(String actionDes) {
        this.actionDes = actionDes;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "BankRollLogInfo{" +
                "logId=" + logId +
                ", uid=" + uid +
                ", bankRollId=" + bankRollId +
                ", money=" + money +
                ", code=" + code +
                ", actionCode=" + actionCode +
                ", actionTime=" + actionTime +
                ", actionDes='" + actionDes + '\'' +
                ", operator=" + operator +
                '}';
    }
}
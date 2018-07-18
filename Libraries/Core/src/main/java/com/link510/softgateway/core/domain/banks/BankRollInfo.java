package com.link510.softgateway.core.domain.banks;

import javax.persistence.*;
import java.io.Serializable;

//用户流水
@Entity
@Table(name = "w_bankroll")
public class BankRollInfo implements Serializable {


    private static final long serialVersionUID = -6062750906734408134L;
    /**
     * 流水id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;

//    /**
//     * 发现id
//     **/
//    @Column(name = "findid", nullable = false)
//    private Integer findId = 0;


    /**
     * 流水动作
     **/
    @Column(name = "bankaction", nullable = false)
    private Integer bankAction = 1;

    /**
     * 操作人
     **/
    @Column(name = "operator", nullable = false)
    private Integer operator = -1;

    /**
     * 涉及金额
     **/
    @Column(name = "money", nullable = false)
    private double money = 1;

    /**
     * 手续费
     **/
    @Column(name = "commission", nullable = false)
    private double commission = 0.00;

    /**
     * 实际到账金额
     **/
    @Column(name = "factmoney", nullable = false)
    private double factMoney = 0.00;

    /**
     * 状态
     **/
    @Column(name = "state", nullable = false)
    private Integer state = 0;

    /**
     * 添加时间
     **/
    @Column(name = "addtime", nullable = false)
    private Integer addTime = 0;

    /**
     * 更新时间
     **/
    @Column(name = "updatetime", nullable = false)
    private Integer updateTime = 0;

    /**
     * 完成 时间
     **/
    @Column(name = "completetime", nullable = false)
    private Integer completeTime = 0;

    /**
     * 描述
     **/
    @Column(name = "description", nullable = false)
    private String description = "";

    /**
     * 详细藐视
     **/
    @Column(name = "body", nullable = false)
    private String body = "";


    public BankRollInfo() {
    }

    public BankRollInfo(Integer uid, Integer bankAction, Integer operator, double money, double commission, double factMoney, Integer state, Integer addTime, Integer updateTime, Integer completeTime, String description, String body) {
        this.uid = uid;
        this.bankAction = bankAction;
        this.operator = operator;
        this.money = money;
        this.commission = commission;
        this.factMoney = factMoney;
        this.state = state;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.completeTime = completeTime;
        this.description = description;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBankAction() {
        return bankAction;
    }

    public void setBankAction(Integer bankAction) {
        this.bankAction = bankAction;
    }


    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) {
        this.factMoney = factMoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Integer completeTime) {
        this.completeTime = completeTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BankRollInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", bankAction=" + bankAction +
                ", operator=" + operator +
                ", money=" + money +
                ", commission=" + commission +
                ", factMoney=" + factMoney +
                ", state=" + state +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", completeTime=" + completeTime +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
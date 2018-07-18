package com.link510.softgateway.web.api.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class SendCashModel {

    /**
     * 提现金额
     */

    @NotNull(message = "请输入正确的提现金额")
    @Range(min = 1, max = 10000, message = "请输入正确的提现金额")
    private double money = 0;

    public SendCashModel() {
    }

    public SendCashModel(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "SendCashModel{" +
                "money=" + money +
                '}';
    }
}

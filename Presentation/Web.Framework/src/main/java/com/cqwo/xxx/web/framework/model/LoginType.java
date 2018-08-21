package com.cqwo.xxx.web.framework.model;

public enum LoginType {

    UserLogin(0, "用户登录"),
    TokenLogin(1, "token登录");

    private Integer index;

    private String name;

    LoginType(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

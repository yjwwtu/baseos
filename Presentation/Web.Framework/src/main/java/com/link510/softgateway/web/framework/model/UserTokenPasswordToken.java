package com.link510.softgateway.web.framework.model;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserTokenPasswordToken extends UsernamePasswordToken {


    private Integer type = 0;


    public UserTokenPasswordToken(String account, String password) {
        super(account, password);
        this.type = 0;
    }

    public UserTokenPasswordToken(String username, char[] password, Integer type) {
        super(username, password);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, String password, Integer type) {
        super(username, password);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, char[] password, String host, Integer type) {
        super(username, password, host);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, String password, String host, Integer type) {
        super(username, password, host);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, char[] password, boolean rememberMe, Integer type) {
        super(username, password, rememberMe);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, String password, boolean rememberMe, Integer type) {
        super(username, password, rememberMe);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, char[] password, boolean rememberMe, String host, Integer type) {
        super(username, password, rememberMe, host);
        this.type = type;
    }

    public UserTokenPasswordToken(String username, String password, boolean rememberMe, String host, Integer type) {
        super(username, password, rememberMe, host);
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

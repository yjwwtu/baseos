package com.link510.softgateway.core.domain.base;


import javax.persistence.*;
import java.io.Serializable;

//信息配置文件
@Entity
@Table(name = "w_sysconfig")
public class SYSConfigInfo implements Serializable {


    private static final long serialVersionUID = -7966650301907548911L;
    /**
     * 配置id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 变量名称
     **/
    @Column(name = "varname", nullable = false)
    private String varName = "";

    /**
     * 变量说明
     **/
    @Column(name = "vardesc", nullable = false)
    private String varDesc = "";

    /**
     * 变量类型
     **/
    @Column(name = "type", nullable = false)
    private String type = "json";

    /**
     * 变量值
     **/
    @Column(name = "varvalue", nullable = false)
    private String varValue = "";

    public SYSConfigInfo() {
    }

    public SYSConfigInfo(String varName, String varDesc, String type, String varValue) {
        this.varName = varName;
        this.varDesc = varDesc;
        this.type = type;
        this.varValue = varValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getVarDesc() {
        return varDesc;
    }

    public void setVarDesc(String varDesc) {
        this.varDesc = varDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVarValue() {
        return varValue;
    }

    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

    @Override
    public String toString() {
        return "SysConfigInfo{" +
                "id=" + id +
                ", varName='" + varName + '\'' +
                ", varDesc='" + varDesc + '\'' +
                ", type='" + type + '\'' +
                ", varValue='" + varValue + '\'' +
                '}';
    }
}
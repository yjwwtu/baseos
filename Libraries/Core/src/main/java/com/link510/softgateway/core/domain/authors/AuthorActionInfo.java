package com.link510.softgateway.core.domain.authors;


import javax.persistence.*;
import java.io.Serializable;

//用户动作表
@Entity
@Table(name = "w_author_actions")
public class AuthorActionInfo implements Serializable {


    private static final long serialVersionUID = -2227297665686562449L;
    /**
     * aid
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid = 0;

    /**
     * action
     **/
    @Column(name = "action", nullable = false)
    private String action = "";

    /**
     * 排序
     **/
    @Column(name = "displayorder", nullable = false)
    private Integer displayOrder = 50;

    /**
     * 上级id
     **/
    @Column(name = "parentid", nullable = false)
    private Integer parentId = 0;

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false)
    private String title = "";


    public AuthorActionInfo() {
    }

    public AuthorActionInfo(Integer aid) {
        this.aid = aid;
    }

    public AuthorActionInfo(String action, Integer displayOrder, Integer parentId, String title) {
        this.action = action;
        this.displayOrder = displayOrder;
        this.parentId = parentId;
        this.title = title;
    }


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AuthorActionInfo{" +
                "aid=" + aid +
                ", action='" + action + '\'' +
                ", displayOrder=" + displayOrder +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                '}';
    }
}
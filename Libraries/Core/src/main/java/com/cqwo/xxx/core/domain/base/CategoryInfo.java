package com.cqwo.xxx.core.domain.base;

import javax.persistence.*;
import java.io.Serializable;

//发现分类
@Entity
@Table(name = "w_category")
public class CategoryInfo implements Serializable {


    private static final long serialVersionUID = -3894265471029230792L;
    /**
     * 分类id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateId = 0;

    /**
     * type
     **/
    @Column(name = "typeid", nullable = false)
    private Integer typeId = 0;


    /**
     * type
     **/
    @Column(name = "warntype", nullable = false)
    private Integer warnType = 0;

    /**
     * 分类名称
     **/
    @Column(name = "name", nullable = false)
    private String name = "";

    /**
     * 栏目图标
     **/
    @Column(name = "icon", nullable = false)
    private String icon = "";

    /**
     * 上级栏目Id
     **/
    @Column(name = "parentid", nullable = false)
    private Integer parentId = 0;

    /**
     * 顶级栏目id
     **/
    @Column(name = "topid", nullable = false)
    private Integer topId = 0;

    /**
     * 栏目层次
     **/
    @Column(name = "layer", nullable = false)
    private Integer layer = 0;

    /**
     * 栏目关键词
     **/
    @Column(name = "keywords", nullable = false)
    private String keywords = "";

    /**
     * 栏目描述
     **/
    @Column(name = "description", nullable = false)
    private String description = "";

    /**
     * 栏目排序
     **/
    @Column(name = "displayorder", nullable = false)
    private Integer displayOrder = 0;

    public CategoryInfo() {
    }

    public CategoryInfo(Integer typeId, Integer warnType, String name, String icon, Integer parentId, Integer topId, Integer layer, String keywords, String description, Integer displayOrder) {
        this.typeId = typeId;
        this.warnType = warnType;
        this.name = name;
        this.icon = icon;
        this.parentId = parentId;
        this.topId = topId;
        this.layer = layer;
        this.keywords = keywords;
        this.description = description;
        this.displayOrder = displayOrder;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getWarnType() {
        return warnType;
    }

    public void setWarnType(Integer warnType) {
        this.warnType = warnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "cateId=" + cateId +
                ", typeId=" + typeId +
                ", warnType=" + warnType +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId=" + parentId +
                ", topId=" + topId +
                ", layer=" + layer +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
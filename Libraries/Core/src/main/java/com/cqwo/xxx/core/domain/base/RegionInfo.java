/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.xxx.core.domain.base;


import javax.persistence.*;
import java.io.Serializable;

//区域信息
@Entity
@Table(name = "w_commom_regions")
public class RegionInfo implements Serializable {

    private static final long serialVersionUID = -6747778980750175138L;
    /**
     * 区域id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regionid")
    private Integer regionId = 0;


    /**
     * 名称
     **/
    @Column(name = "name", nullable = false, length = 30)
    private String name = "";

    /**
     * 名称
     **/
    @Column(name = "engname", nullable = false, length = 30)
    private String engName = "";


    /**
     * 拼写
     **/
    @Column(name = "spell", nullable = false, length = 30)
    private String spell = "";


    /**
     * 简拼
     **/
    @Column(name = "shortspell", nullable = false, length = 20)
    private String shortSpell = "";


    /**
     * 排序
     **/
    @Column(name = "displayorder", nullable = false)
    private Integer displayOrder = 0;


    /**
     * 父id
     **/
    @Column(name = "parentid", nullable = false)
    private Integer parentId = 0;


    /**
     * 级别
     **/
    @Column(name = "layer", nullable = false)
    private Integer layer = 0;


    /**
     * 省id
     **/
    @Column(name = "provinceid", nullable = false)
    private Integer provinceId = 0;


    /**
     * 省名称
     **/
    @Column(name = "provincename", nullable = false, length = 20)
    private String provinceName = "";


    /**
     * 市id
     **/
    @Column(name = "cityid", nullable = false)
    private Integer cityId = 0;


    /**
     * 市名称
     **/
    @Column(name = "cityname", nullable = false, length = 20)
    private String cityName = "";

    public RegionInfo() {
    }

    public RegionInfo(Integer regionId) {
        this.regionId = regionId;
    }


    public RegionInfo(String name, String spell, String shortSpell, Integer displayOrder, Integer parentId, Integer layer, Integer provinceId, String provinceName, Integer cityId, String cityName) {
        this.name = name;
        this.spell = spell;
        this.shortSpell = shortSpell;
        this.displayOrder = displayOrder;
        this.parentId = parentId;
        this.layer = layer;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.cityId = cityId;
        this.cityName = cityName;
    }


    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getShortSpell() {
        return shortSpell;
    }

    public void setShortSpell(String shortSpell) {
        this.shortSpell = shortSpell;
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

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "RegionInfo{" +
                "regionId=" + regionId +
                ", name='" + name + '\'' +
                ", engName='" + engName + '\'' +
                ", spell='" + spell + '\'' +
                ", shortSpell='" + shortSpell + '\'' +
                ", displayOrder=" + displayOrder +
                ", parentId=" + parentId +
                ", layer=" + layer +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
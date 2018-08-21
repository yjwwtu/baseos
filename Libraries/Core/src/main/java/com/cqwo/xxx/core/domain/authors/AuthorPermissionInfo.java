package com.cqwo.xxx.core.domain.authors;

import javax.persistence.*;
import java.io.Serializable;

//角色许可表
@Entity
@Table(name = "w_author_permissions")
public class AuthorPermissionInfo implements Serializable {


    private static final long serialVersionUID = 3164302230408551310L;
    /**
     * Id
     **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户角色id
     **/
    @Column(name = "roleid", nullable = false)
    private Integer roleId = 0;

    /**
     * 动作id
     **/
    @Id
    private Integer aid = 0;

    public AuthorPermissionInfo() {
    }

    public AuthorPermissionInfo(Integer aid) {
        this.aid = aid;
    }

    public AuthorPermissionInfo(Integer roleId, Integer aid) {
        this.roleId = roleId;
        this.aid = aid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "AuthorPermissionInfo{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", aid=" + aid +
                '}';
    }
}
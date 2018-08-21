package com.cqwo.xxx.core.domain.authors;

import javax.persistence.*;
import java.io.Serializable;

//用户分组表
@Entity
@Table(name = "w_author_roles")
public class AuthorRoleInfo implements Serializable {


    private static final long serialVersionUID = -7169807466024299037L;
    /**
     * id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId = 0;

    /**
     * 分组名称
     **/
    @Column(name = "title", nullable = false)
    private String title = "";

    /**
     * 分组标识
     */
    @Column(name = "code", nullable = false, length = 20)
    private String code = "";

    /**
     * 分组描述
     **/
    @Column(name = "description", nullable = false)
    private String description = "";

    public AuthorRoleInfo() {
    }

    public AuthorRoleInfo(Integer roleId) {
        this.roleId = roleId;
    }

    public AuthorRoleInfo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public AuthorRoleInfo(String title, String code, String description) {
        this.title = title;
        this.code = code;
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AuthorRoleInfo{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
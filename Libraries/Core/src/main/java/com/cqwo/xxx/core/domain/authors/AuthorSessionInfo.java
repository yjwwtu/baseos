package com.cqwo.xxx.core.domain.authors;

import javax.persistence.*;
import java.io.Serializable;

//用户-组关联表
@Entity
@Table(name = "w_author_sessions")
public class AuthorSessionInfo implements Serializable {


    private static final long serialVersionUID = -2426142183869450857L;
    /**
     * Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;

    /**
     * 用户组id
     **/
    @Column(name = "roleid", nullable = false)
    private Integer roleId = 0;

    public AuthorSessionInfo() {
    }

    public AuthorSessionInfo(Integer id) {
        this.id = id;
    }

    public AuthorSessionInfo(Integer uid, Integer roleId) {
        this.uid = uid;
        this.roleId = roleId;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AuthorSessionInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", roleId=" + roleId +
                '}';
    }
}
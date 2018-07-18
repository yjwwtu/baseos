package com.link510.softgateway.core.domain.forums;

import com.link510.softgateway.core.helper.DateHelper;

import javax.persistence.*;
import java.io.Serializable;

//论坛点赞表
@Entity
@Table(name = "w_forum_praise")
public class ForumPraiseInfo implements Serializable {


    private static final long serialVersionUID = 2083538393444637491L;
    /**
     * 点赞id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer praiseId = 0;

    /**
     * 帖子id
     **/
    @Column(name = "forumid", nullable = false)
    private Integer forumId = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;

    /**
     * 用户昵称
     **/
    @Column(name = "nickname", nullable = false)
    private String nickName = "";

    /**
     * 点赞时间
     **/
    @Column(name = "praisetime", nullable = false)
    private Integer praiseTime = DateHelper.getUnixTimeStamp();

    public ForumPraiseInfo() {
    }

    public ForumPraiseInfo(Integer forumId, Integer uid, String nickName, Integer praiseTime) {
        this.forumId = forumId;
        this.uid = uid;
        this.nickName = nickName;
        this.praiseTime = praiseTime;
    }

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Integer praiseTime) {
        this.praiseTime = praiseTime;
    }

    @Override
    public String toString() {
        return "ForumPraiseInfo{" +
                "praiseId=" + praiseId +
                ", forumId=" + forumId +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", praiseTime=" + praiseTime +
                '}';
    }
}
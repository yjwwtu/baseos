package com.cqwo.xxx.core.domain.forums;

import com.cqwo.xxx.core.helper.DateHelper;

import javax.persistence.*;
import java.io.Serializable;

//论坛回复
@Entity
@Table(name = "w_forum_post")
public class ForumPostInfo implements Serializable {


    private static final long serialVersionUID = 7077746077965668283L;
    /**
     * 回帖id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId = 0;

    /**
     * 帖子Id
     **/
    @Column(name = "forumid", nullable = false)
    private Integer forumId = 0;

    /**
     * 分类id
     **/
    @Column(name = "cateid", nullable = false)
    private Integer cateId = 0;

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
     * 当前楼层
     **/
    @Column(name = "layer", nullable = false)
    private Integer layer = 0;

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false)
    private String title = "";

    /**
     * @用户
     **/
    @Column(name = "at", nullable = false)
    private String at = "";

    /**
     * 内容
     **/
    @Column(name = "body", nullable = false)
    private String body = "";

    /**
     * 回贴时间
     **/
    @Column(name = "posttime", nullable = false)
    private Integer postTime = DateHelper.getUnixTimeStamp();

    /**
     * 更新时间
     **/
    @Column(name = "updatetime", nullable = false)
    private Integer updateTime = DateHelper.getUnixTimeStamp();

    /**
     * 是否删除
     **/
    @Column(name = "isdelete", nullable = false)
    private Integer isDelete = 0;

    public ForumPostInfo() {
    }

    public ForumPostInfo(Integer forumId, Integer cateId, Integer uid, String nickName, Integer layer, String title, String at, String body, Integer postTime, Integer updateTime, Integer isDelete) {
        this.forumId = forumId;
        this.cateId = cateId;
        this.uid = uid;
        this.nickName = nickName;
        this.layer = layer;
        this.title = title;
        this.at = at;
        this.body = body;
        this.postTime = postTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
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

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPostTime() {
        return postTime;
    }

    public void setPostTime(Integer postTime) {
        this.postTime = postTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ForumPostInfo{" +
                "postId=" + postId +
                ", forumId=" + forumId +
                ", cateId=" + cateId +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", layer=" + layer +
                ", title='" + title + '\'' +
                ", at='" + at + '\'' +
                ", body='" + body + '\'' +
                ", postTime=" + postTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
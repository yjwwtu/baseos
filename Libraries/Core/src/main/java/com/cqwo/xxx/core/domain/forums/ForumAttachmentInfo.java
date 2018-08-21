package com.cqwo.xxx.core.domain.forums;

import javax.persistence.*;
import java.io.Serializable;

//论坛附件表
@Entity
@Table(name = "w_forum_attachment")
public class ForumAttachmentInfo implements Serializable {


    private static final long serialVersionUID = 5831378247865116958L;


    /**
     * 附件id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 附件id
     **/
    @Column(name = "attachid")
    private Integer attachId = 0;

    /**
     * 帖子id
     **/
    @Column(name = "forumid", nullable = false)
    private Integer forumId = 0;


    public ForumAttachmentInfo() {
    }

    public ForumAttachmentInfo(Integer attachId, Integer forumId) {
        this.attachId = attachId;
        this.forumId = forumId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    @Override
    public String toString() {
        return "ForumAttachmentInfo{" +
                "id=" + id +
                ", attachId=" + attachId +
                ", forumId=" + forumId +
                '}';
    }
}
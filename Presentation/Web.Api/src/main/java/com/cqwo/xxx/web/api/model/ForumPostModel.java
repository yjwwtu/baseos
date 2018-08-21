package com.cqwo.xxx.web.api.model;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户回贴
 */
public class ForumPostModel {

    @NotNull(message = "用户标题不")
    private Integer forumId;

    /**
     * 详细内容
     */
    @Length(min = 2, max = 500, message = "圈子长度内容为2到500")
    @NotNull(message = "请认真填写内容")
    private String body = "";

    /**
     * 邀请谁关注
     */
    private String at = "";

    public ForumPostModel() {
    }

    public ForumPostModel(@NotNull(message = "用户标题不") Integer forumId, @Length(min = 5, max = 500, message = "圈子长度内容为5到500") @NotNull(message = "请认真填写内容") String body, String at) {
        this.forumId = forumId;
        this.body = body;
        this.at = at;
    }


    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public String toString() {
        return "ForumPostModel{" +
                "forumId=" + forumId +
                ", body='" + body + '\'' +
                ", at='" + at + '\'' +
                '}';
    }
}

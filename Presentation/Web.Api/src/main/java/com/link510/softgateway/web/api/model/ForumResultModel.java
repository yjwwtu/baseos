package com.link510.softgateway.web.api.model;

import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.domain.forums.ForumInfo;

public class ForumResultModel {

    /**
     * 圈子id
     */
    private Integer forumId;

    /**
     * 圈子内容
     */
    private ForumInfo forumInfo;

    public ForumResultModel() {
    }

    public ForumResultModel(Integer forumId, ForumInfo forumInfo) {
        this.forumId = forumId;
        this.forumInfo = forumInfo;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public ForumInfo getForumInfo() {
        return forumInfo;
    }

    public void setForumInfo(ForumInfo forumInfo) {
        this.forumInfo = forumInfo;
    }

    @Override
    public String toString() {
        return "ForumResultModel{" +
                "forumId=" + forumId +
                ", forumInfo=" + forumInfo +
                '}';
    }
}

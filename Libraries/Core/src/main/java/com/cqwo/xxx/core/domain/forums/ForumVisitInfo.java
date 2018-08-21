package com.cqwo.xxx.core.domain.forums;

import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;

import java.util.ArrayList;
import java.util.List;

public class ForumVisitInfo {

    /**
     * 圈子id
     */
    private Integer forumId;

    /**
     * 圈子正文
     */
    private ForumInfo forumInfo;


    /**
     * 圈子所属分类
     */
    private CategoryInfo categoryInfo;


    /**
     * 发贴人信息
     */
    private PartUserInfo userInfo;


    /**
     * 最新回复
     */
    private List<ForumPostInfo> forumPostInfoList;

    /**
     * 附件列表
     */
    private List<AttachmentInfo> attachmentInfoList;

    /**
     * 附件String列表
     */
    private List<String> attachmentList;


    /**
     * 是否已点赞
     */
    private boolean isPraise = false;


    public ForumVisitInfo() {
    }

    public ForumVisitInfo(Integer forumId, ForumInfo forumInfo, CategoryInfo categoryInfo, PartUserInfo userInfo, List<ForumPostInfo> forumPostInfoList, List<AttachmentInfo> attachmentInfoList, List<String> attachmentList, boolean isPraise) {
        this.forumId = forumId;
        this.forumInfo = forumInfo;
        this.categoryInfo = categoryInfo;
        this.userInfo = userInfo;
        this.forumPostInfoList = forumPostInfoList;
        this.attachmentInfoList = attachmentInfoList;
        this.attachmentList = attachmentList;
        this.isPraise = isPraise;
    }

    public ForumVisitInfo(Integer forumId, ForumInfo forumInfo, CategoryInfo categoryInfo, PartUserInfo userInfo, List<ForumPostInfo> forumPostInfoList, List<AttachmentInfo> attachmentInfoList, boolean isPraise) {
        this.forumId = forumId;
        this.forumInfo = forumInfo;
        this.categoryInfo = categoryInfo;
        this.userInfo = userInfo;
        this.forumPostInfoList = forumPostInfoList;
        this.attachmentInfoList = attachmentInfoList;

        List<String> attachmentList = new ArrayList<>();

        for (AttachmentInfo info : attachmentInfoList) {
            attachmentList.add(info.getUrl());
        }

        this.attachmentList = attachmentList;
        this.isPraise = isPraise;
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

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public PartUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(PartUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<ForumPostInfo> getForumPostInfoList() {
        return forumPostInfoList;
    }

    public void setForumPostInfoList(List<ForumPostInfo> forumPostInfoList) {
        this.forumPostInfoList = forumPostInfoList;
    }

    public List<AttachmentInfo> getAttachmentInfoList() {
        return attachmentInfoList;
    }

    public void setAttachmentInfoList(List<AttachmentInfo> attachmentInfoList) {
        this.attachmentInfoList = attachmentInfoList;
    }

    public List<String> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<String> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public boolean isPraise() {
        return isPraise;
    }

    public void setPraise(boolean praise) {
        isPraise = praise;
    }

    @Override
    public String toString() {
        return "ForumVisitInfo{" +
                "forumId=" + forumId +
                ", forumInfo=" + forumInfo +
                ", categoryInfo=" + categoryInfo +
                ", userInfo=" + userInfo +
                ", forumPostInfoList=" + forumPostInfoList +
                ", attachmentInfoList=" + attachmentInfoList +
                ", attachmentList=" + attachmentList +
                ", isPraise=" + isPraise +
                '}';
    }
}

package com.cqwo.xxx.web.api.model;

import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.web.framework.model.SimplePageModel;

import java.util.List;

public class ForumShowModel extends ForumVisitInfo {

    /**
     * 简单分页
     */
    private SimplePageModel pageModel;

    public ForumShowModel() {
    }

    public ForumShowModel(Integer forumId, ForumInfo forumInfo, CategoryInfo categoryInfo, PartUserInfo userInfo, List<ForumPostInfo> forumPostInfoList, List<AttachmentInfo> attachmentInfoList, boolean isPraise) {
        super(forumId, forumInfo, categoryInfo, userInfo, forumPostInfoList, attachmentInfoList, isPraise);
    }

    public ForumShowModel(SimplePageModel pageModel) {
        this.pageModel = pageModel;
    }

    public ForumShowModel(Integer forumId, ForumInfo forumInfo, CategoryInfo categoryInfo, PartUserInfo userInfo, List<ForumPostInfo> forumPostInfoList, List<AttachmentInfo> attachmentInfoList, boolean isPraise, SimplePageModel pageModel) {
        super(forumId, forumInfo, categoryInfo, userInfo, forumPostInfoList, attachmentInfoList, isPraise);
        this.pageModel = pageModel;
    }

    public SimplePageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(SimplePageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "ForumShowModel{" +
                "pageModel=" + pageModel +
                '}';
    }
}

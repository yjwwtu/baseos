package com.cqwo.xxx.web.api.model;

import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.web.framework.model.SimplePageModel;

import java.util.List;

public class ForumListModel {

    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 视图列表
     */
    private List<ForumVisitInfo> forumInfoList;

    /**
     * 分页模型
     */
    private SimplePageModel pageModel;


    public ForumListModel(Integer cateId, List<ForumVisitInfo> forumInfoList, SimplePageModel pageModel) {
        this.cateId = cateId;
        this.forumInfoList = forumInfoList;
        this.pageModel = pageModel;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public List<ForumVisitInfo> getForumInfoList() {
        return forumInfoList;
    }

    public void setForumInfoList(List<ForumVisitInfo> forumInfoList) {
        this.forumInfoList = forumInfoList;
    }

    public SimplePageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(SimplePageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "ForumListModel{" +
                "cateId=" + cateId +
                ", forumInfoList=" + forumInfoList +
                ", pageModel=" + pageModel +
                '}';
    }
}

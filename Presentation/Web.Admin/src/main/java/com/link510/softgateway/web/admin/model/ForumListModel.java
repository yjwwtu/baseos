package com.link510.softgateway.web.admin.model;

import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.web.framework.model.PageModel;

import java.util.List;

public class ForumListModel {

    /**
     * 分类id
     */
    private Integer cateId;


    private String keywords;

    /**
     * 视图列表
     */
    private List<ForumInfo> forumInfoList;

    /**
     * 分页模型
     */
    private PageModel pageModel;


    public ForumListModel(Integer cateId, String keywords, List<ForumInfo> forumInfoList, PageModel pageModel) {
        this.cateId = cateId;
        this.keywords = keywords;
        this.forumInfoList = forumInfoList;
        this.pageModel = pageModel;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<ForumInfo> getForumInfoList() {
        return forumInfoList;
    }

    public void setForumInfoList(List<ForumInfo> forumInfoList) {
        this.forumInfoList = forumInfoList;
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    @Override
    public String toString() {
        return "ForumListModel{" +
                "cateId=" + cateId +
                ", keywords='" + keywords + '\'' +
                ", forumInfoList=" + forumInfoList +
                ", pageModel=" + pageModel +
                '}';
    }
}

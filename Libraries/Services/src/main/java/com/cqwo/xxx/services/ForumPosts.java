package com.cqwo.xxx.services;

import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */

//论坛回复
@Service(value = "ForumPosts")
public class ForumPosts {
    @Resource(name = "ForumPostsData")
    com.cqwo.xxx.data.ForumPosts forumPosts;


    @Autowired
    private Logs logs;

    //region  论坛回复方法

    /**
     * 获得论坛回复数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumPostCount(Specification<ForumPostInfo> condition) {

        try {
            return forumPosts.getForumPostCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛回复数量失败");
        }
        return 0;
    }

    /**
     * 创建一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     * @return 返回创建信息
     **/
    public ForumPostInfo createForumPost(ForumPostInfo forumpostInfo) {
        try {


            return forumPosts.createForumPost(forumpostInfo);
        } catch (Exception ex) {
            logs.Write("带入参数:" + forumpostInfo.toString());
            logs.Write(ex, "创建一条论坛回复数据失败");
        }
        return null;
    }

    /**
     * 更新一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     **/
    public ForumPostInfo updateForumPost(ForumPostInfo forumpostInfo) {
        try {
            return forumPosts.updateForumPost(forumpostInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条论坛回复数据异常");
        }

        return null;
    }

    /**
     * 删除一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    public void deleteForumPostByPostId(Integer postId) {
        try {
            forumPosts.deleteForumPostByPostId(postId);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条论坛回复数据异常");
        }
    }

    /**
     * 批量删除一批论坛回复数据
     **/
    public void deleteForumPostByPostIdList(String postIdList) {
        try {
            forumPosts.deleteForumPostByPostIdList(postIdList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批论坛回复数据异常");
        }
    }

    /**
     * 获取一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    public ForumPostInfo getForumPostByPostId(Integer postId) {
        try {
            return forumPosts.getForumPostByPostId(postId);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条论坛回复数据");
        }

        return null;
    }


    /**
     * 获得论坛回复数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPostInfo
     **/
    public List<ForumPostInfo> getForumPostList(Specification<ForumPostInfo> condition, Sort sort) {

        List<ForumPostInfo> forumPostList = new ArrayList<ForumPostInfo>();

        try {
            forumPostList = forumPosts.getForumPostList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛回复数据列表异常");
        }

        return forumPostList;
    }


    /**
     * 获得论坛回复数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPostInfo
     **/
    public Page<ForumPostInfo> getForumPostList(Integer pageSize, Integer pageNumber, Specification<ForumPostInfo> condition, Sort sort) {

        Page<ForumPostInfo> forumPostList = null;

        try {
            forumPostList = forumPosts.getForumPostList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛回复数据列表异常");
        }

        return forumPostList;
    }


    /**
     * 获取指定的列表
     *
     * @param forumId    forumId
     * @param pageSize   每页条数
     * @param pageNumber 当前页数
     * @return
     */
    public Page<ForumPostInfo> getForumPostList(Integer forumId, Integer pageSize, Integer pageNumber) {

        Page<ForumPostInfo> forumPostList = null;

        try {
            forumPostList = forumPosts.getForumPostList(forumId, pageSize, pageNumber);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛回复数据列表异常");
        }

        return forumPostList;
    }

    /**
     * 获取最新的几个回帖列表
     *
     * @param forumId
     * @param pageSize
     * @return
     */
    public List<ForumPostInfo> getNewForumPostList(Integer forumId, Integer pageSize) {

        List<ForumPostInfo> forumPostInfoList = new ArrayList<>();

        try {

            Page<ForumPostInfo> infoPage = getForumPostList(forumId, pageSize, 1);

            if (infoPage != null && infoPage.getTotalElements() >= 1) {
                forumPostInfoList = infoPage.getContent();
            }


        } catch (Exception ex) {

            logs.Write(ex, "获取最新的几个回帖列表");
        }

        return forumPostInfoList;


    }

    /**
     * 获取当前的楼层
     *
     * @param forumId 圈子id
     * @return
     */
    public Integer getForumPostLayer(Integer forumId) {

        Integer layer = 0;
        try {
            layer = forumPosts.getForumPostLayer(forumId);

        } catch (Exception ex) {
            logs.Write(ex, "获取当前的楼层");
        }

        return ++layer;
    }

    //endregion

}

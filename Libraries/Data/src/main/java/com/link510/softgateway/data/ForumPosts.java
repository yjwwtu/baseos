package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.forums.ForumPostInfo;
import com.link510.softgateway.core.domain.forums.ForumPostInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//论坛回复
@Service(value = "ForumPostsData")
public class ForumPosts extends DataService {


    //region  论坛回复方法

    /**
     * 获得论坛回复数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumPostCount(Specification<ForumPostInfo> condition) throws IOException {
        return getCwmData().getIForumStrategy().getForumPostCount(condition);
    }

    /**
     * 创建一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     * @return 返回创建信息
     **/
    public ForumPostInfo createForumPost(ForumPostInfo forumpostInfo) throws IOException {
        return getCwmData().getIForumStrategy().createForumPost(forumpostInfo);
    }

    /**
     * 更新一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     **/
    public ForumPostInfo updateForumPost(ForumPostInfo forumpostInfo) throws IOException {
        return getCwmData().getIForumStrategy().updateForumPost(forumpostInfo);
    }

    /**
     * 删除一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    public void deleteForumPostByPostId(Integer postId) throws IOException {
        getCwmData().getIForumStrategy().deleteForumPostByPostId(postId);
    }

    /**
     * 批量删除一批论坛回复数据
     **/
    public void deleteForumPostByPostIdList(String postIdList) throws IOException {
        getCwmData().getIForumStrategy().deleteForumPostByPostIdList(postIdList);
    }

    /**
     * 获取一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    public ForumPostInfo getForumPostByPostId(Integer postId) throws IOException {
        return getCwmData().getIForumStrategy().getForumPostByPostId(postId);
    }


    /**
     * 获得论坛回复数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPostInfo
     **/
    public List<ForumPostInfo> getForumPostList(Specification<ForumPostInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumPostList(condition, sort);
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
    public Page<ForumPostInfo> getForumPostList(Integer pageSize, Integer pageNumber, Specification<ForumPostInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumPostList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获取指定的列表
     *
     * @param forumId    forumId
     * @param pageSize   每页条数
     * @param pageNumber 当前页数
     * @return
     */
    public Page<ForumPostInfo> getForumPostList(Integer forumId, Integer pageSize, Integer pageNumber) throws IOException {

        return getCwmData().getIForumStrategy().getForumPostList(forumId, pageSize, pageNumber);
    }

    /**
     * 获取当前的楼层
     *
     * @param forumId 圈子id
     * @return
     */
    public Integer getForumPostLayer(Integer forumId) throws IOException {
        return getCwmData().getIForumStrategy().getForumPostLayer(forumId);
    }


    //endregion

}

package com.link510.softgateway.core.data.rdbs;

import com.link510.softgateway.core.domain.base.AttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumAttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.domain.forums.ForumPostInfo;
import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;


/**
 * 论坛数据库策略
 */
public interface IForumStrategy {



    //region 论坛主表

    /**
     * 获得论坛主表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getForumCount(Specification<ForumInfo> condition) throws IOException;


    /**
     * 创建一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     * @return 返回创建信息
     **/
    ForumInfo createForum(ForumInfo forumInfo) throws IOException;


    /**
     * 更新一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     **/
    ForumInfo updateForum(ForumInfo forumInfo) throws IOException;

    /**
     * 删除一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    void deleteForumByForumId(Integer forumId) throws IOException;

    /**
     * 批量删除一批论坛主表数据
     **/
    void deleteForumByForumIdList(String forumIdList) throws IOException;


    /**
     * 获得论坛主表一条记录
     *
     * @param forumId forumid
     * @return 返回一条ForumInfo
     **/
    ForumInfo getForumByForumId(Integer forumId) throws IOException;

    /**
     * 获得论坛主表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumInfo
     **/
    List<ForumInfo> getForumList(Specification<ForumInfo> condition, Sort sort) throws IOException;


    /**
     * 获得论坛主表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumInfo
     **/
    Page<ForumInfo> getForumList(Integer pageSize, Integer pageNumber, Specification<ForumInfo> condition, Sort sort) throws IOException;


    /**
     * 获取附近的发贴信息列表
     *
     * @return
     */
    List<ForumInfo> getAroundForumList(Integer cateId, double longitude, double latitude, double dis) throws IOException;

    /**
     * 获取圈子首页列表
     *
     * @return
     */
    List<ForumInfo> getHomeForumList() throws IOException;

    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    List<ForumInfo> getFindSpecieHomeForumList() throws IOException;

    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    List<ForumInfo> getForumListByTypeId(Integer typeId) throws IOException;

    /**
     * 获取列表生成条件
     *
     * @param cateId
     * @return
     */
    Specification<ForumInfo> getForumListCondition(Integer cateId) throws IOException;

    /**
     * 获取后台列表生成条件
     *
     * @param cateId
     * @return
     */
    Specification<ForumInfo> getAdminForumListCondition(Integer cateId, String keywords) throws IOException;

    //endregion 论坛主表结束

    //region 论坛回复

    /**
     * 获得论坛回复数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getForumPostCount(Specification<ForumPostInfo> condition) throws IOException;


    /**
     * 创建一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     * @return 返回创建信息
     **/
    ForumPostInfo createForumPost(ForumPostInfo forumpostInfo) throws IOException;


    /**
     * 更新一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     **/
    ForumPostInfo updateForumPost(ForumPostInfo forumpostInfo) throws IOException;

    /**
     * 删除一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    void deleteForumPostByPostId(Integer postId) throws IOException;

    /**
     * 批量删除一批论坛回复数据
     **/
    void deleteForumPostByPostIdList(String postIdList) throws IOException;


    /**
     * 获得论坛回复一条记录
     *
     * @param postId postid
     * @return 返回一条ForumPostInfo
     **/
    ForumPostInfo getForumPostByPostId(Integer postId) throws IOException;

    /**
     * 获得论坛回复数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPostInfo
     **/
    List<ForumPostInfo> getForumPostList(Specification<ForumPostInfo> condition, Sort sort) throws IOException;


    /**
     * 获得论坛回复数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPostInfo
     **/
    Page<ForumPostInfo> getForumPostList(Integer pageSize, Integer pageNumber, Specification<ForumPostInfo> condition, Sort sort) throws IOException;


    /**
     * 获取指定的列表
     *
     * @param forumId    forumId
     * @param pageSize   每页条数
     * @param pageNumber 当前页数
     * @return
     */
    Page<ForumPostInfo> getForumPostList(Integer forumId, Integer pageSize, Integer pageNumber) throws IOException;


    /**
     * 获取当前的楼层
     *
     * @param forumId 圈子id
     * @return
     */
    Integer getForumPostLayer(Integer forumId) throws IOException;
    //endregion 论坛回复结束

    //region 论坛附件表

    /**
     * 获得论坛附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getForumAttachmentCount(Specification<ForumAttachmentInfo> condition) throws IOException;


    /**
     * 创建一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     * @return 返回创建信息
     **/
    ForumAttachmentInfo createForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException;


    /**
     * 更新一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     **/
    ForumAttachmentInfo updateForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException;


    /**
     * 删除一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    void deleteForumAttachmentByAttachId(Integer attachId) throws IOException;

    /**
     * 批量删除一批论坛附件表数据
     **/
    void deleteForumAttachmentByAttachIdList(String attachIdList) throws IOException;


    /**
     * 获得论坛附件表一条记录
     *
     * @param attachId attachid
     * @return 返回一条ForumAttachmentInfo
     **/
    ForumAttachmentInfo getForumAttachmentByAttachId(Integer attachId) throws IOException;

    /**
     * 获得论坛附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumAttachmentInfo
     **/
    List<ForumAttachmentInfo> getForumAttachmentList(Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException;


    /**
     * 获得论坛附件表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumAttachmentInfo
     **/
    Page<ForumAttachmentInfo> getForumAttachmentList(Integer pageSize, Integer pageNumber, Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException;


    /**
     * 获取贴子的附件列表
     *
     * @param forumId
     * @return
     */
    List<AttachmentInfo> getAttachmentListByForumId(Integer forumId) throws IOException;
    //endregion 论坛附件表结束

    //region 论坛点赞表

    /**
     * 获得论坛点赞表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getForumPraiseCount(Specification<ForumPraiseInfo> condition) throws IOException;


    /**
     * 创建一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     * @return 返回创建信息
     **/
    ForumPraiseInfo createForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException;


    /**
     * 更新一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     **/
    ForumPraiseInfo updateForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException;

    /**
     * 删除一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    void deleteForumPraiseByPraiseId(Integer praiseId) throws IOException;

    /**
     * 批量删除一批论坛点赞表数据
     **/
    void deleteForumPraiseByPraiseIdList(String praiseIdList) throws IOException;


    /**
     * 判断点赞
     *
     * @param forumId 帖子id
     * @param uid     用户uid
     * @return
     */
    boolean isPraise(Integer forumId, Integer uid) throws IOException;

    /**
     * 获得论坛点赞表一条记录
     *
     * @param praiseId praiseid
     * @return 返回一条ForumPraiseInfo
     **/
    ForumPraiseInfo getForumPraiseByPraiseId(Integer praiseId) throws IOException;

    /**
     * 获得论坛点赞表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPraiseInfo
     **/
    List<ForumPraiseInfo> getForumPraiseList(Specification<ForumPraiseInfo> condition, Sort sort) throws IOException;


    /**
     * 获得论坛点赞表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPraiseInfo
     **/
    Page<ForumPraiseInfo> getForumPraiseList(Integer pageSize, Integer pageNumber, Specification<ForumPraiseInfo> condition, Sort sort) throws IOException;


    //endregion 论坛点赞表结束

}

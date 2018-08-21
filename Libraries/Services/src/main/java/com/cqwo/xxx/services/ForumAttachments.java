package com.cqwo.xxx.services;

import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumAttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */

//论坛附件表
@Service(value = "ForumAttachments")
public class ForumAttachments {
    @Resource(name = "ForumAttachmentsData")
    com.cqwo.xxx.data.ForumAttachments forumAttachments;


    @Autowired
    private Logs logs;

    @Autowired
    private Attachments attachments;


    //region  论坛附件表方法

    /**
     * 获得论坛附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumAttachmentCount(Specification<ForumAttachmentInfo> condition) {

        try {
            return forumAttachments.getForumAttachmentCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛附件表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     * @return 返回创建信息
     **/
    public ForumAttachmentInfo createForumAttachment(ForumAttachmentInfo forumattachmentInfo) {
        try {
            return forumAttachments.createForumAttachment(forumattachmentInfo);
        } catch (Exception ex) {
            logs.Write(ex, "创建一条论坛附件表数据失败");
        }
        return null;
    }

    /**
     * 更新一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     **/
    public ForumAttachmentInfo updateForumAttachment(ForumAttachmentInfo forumattachmentInfo) {
        try {
            return forumAttachments.updateForumAttachment(forumattachmentInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条论坛附件表数据异常");
        }

        return null;
    }

    /**
     * 删除一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    public void deleteForumAttachmentByAttachId(Integer attachId) {
        try {
            forumAttachments.deleteForumAttachmentByAttachId(attachId);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条论坛附件表数据异常");
        }
    }

    /**
     * 批量删除一批论坛附件表数据
     **/
    public void deleteForumAttachmentByAttachIdList(String attachIdList) {
        try {
            forumAttachments.deleteForumAttachmentByAttachIdList(attachIdList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批论坛附件表数据异常");
        }
    }

    /**
     * 获取一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    public ForumAttachmentInfo getForumAttachmentByAttachId(Integer attachId) {
        try {
            return forumAttachments.getForumAttachmentByAttachId(attachId);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条论坛附件表数据");
        }

        return null;
    }


    /**
     * 获得论坛附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumAttachmentInfo
     **/
    public List<ForumAttachmentInfo> getForumAttachmentList(Specification<ForumAttachmentInfo> condition, Sort sort) {

        List<ForumAttachmentInfo> forumAttachmentList = new ArrayList<ForumAttachmentInfo>();

        try {
            forumAttachmentList = forumAttachments.getForumAttachmentList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛附件表数据列表异常");
        }

        return forumAttachmentList;
    }


    /**
     * 获得论坛附件表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumAttachmentInfo
     **/
    public Page<ForumAttachmentInfo> getForumAttachmentList(Integer pageSize, Integer pageNumber, Specification<ForumAttachmentInfo> condition, Sort sort) {

        Page<ForumAttachmentInfo> forumAttachmentList = null;

        try {
            forumAttachmentList = forumAttachments.getForumAttachmentList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛附件表数据列表异常");
        }

        return forumAttachmentList;
    }

    /**
     * 获取贴子的附件列表
     *
     * @param forumId
     * @return
     */
    public List<AttachmentInfo> getAttachmentListByForumId(Integer forumId) {

        List<AttachmentInfo> forumAttachmentList = new ArrayList<AttachmentInfo>();

        try {
            forumAttachmentList = forumAttachments.getAttachmentListByForumId(forumId);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛附件表数据列表异常");
        }

        return forumAttachmentList;
    }

    /**
     * 处理图像
     *
     * @param imgUrlList
     * @param forumInfo
     */
    @Async
    public void createForumAttachment(List<String> imgUrlList, ForumInfo forumInfo) {

        List<AttachmentInfo> attachmentInfoList = attachments.batchCreateAttchment(imgUrlList, forumInfo.getUid(), forumInfo.getTitle());

        for (AttachmentInfo info : attachmentInfoList) {

            ForumAttachmentInfo attachmentInfo = new ForumAttachmentInfo(info.getAttachId(), forumInfo.getForumId());
            createForumAttachment(attachmentInfo);
        }


    }


    //endregion

}

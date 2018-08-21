package com.cqwo.xxx.data;

import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumAttachmentInfo;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumAttachmentInfo;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumAttachmentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//论坛附件表
@Service(value = "ForumAttachmentsData")
public class ForumAttachments extends DataService {


    //region  论坛附件表方法

    /**
     * 获得论坛附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumAttachmentCount(Specification<ForumAttachmentInfo> condition) throws IOException {
        return getCwmData().getIForumStrategy().getForumAttachmentCount(condition);
    }

    /**
     * 创建一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     * @return 返回创建信息
     **/
    public ForumAttachmentInfo createForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException {
        return getCwmData().getIForumStrategy().createForumAttachment(forumattachmentInfo);
    }

    /**
     * 更新一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     **/
    public ForumAttachmentInfo updateForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException {
        return getCwmData().getIForumStrategy().updateForumAttachment(forumattachmentInfo);
    }

    /**
     * 删除一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    public void deleteForumAttachmentByAttachId(Integer attachId) throws IOException {
        getCwmData().getIForumStrategy().deleteForumAttachmentByAttachId(attachId);
    }

    /**
     * 批量删除一批论坛附件表数据
     **/
    public void deleteForumAttachmentByAttachIdList(String attachIdList) throws IOException {
        getCwmData().getIForumStrategy().deleteForumAttachmentByAttachIdList(attachIdList);
    }

    /**
     * 获取一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    public ForumAttachmentInfo getForumAttachmentByAttachId(Integer attachId) throws IOException {
        return getCwmData().getIForumStrategy().getForumAttachmentByAttachId(attachId);
    }


    /**
     * 获得论坛附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumAttachmentInfo
     **/
    public List<ForumAttachmentInfo> getForumAttachmentList(Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumAttachmentList(condition, sort);
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
    public Page<ForumAttachmentInfo> getForumAttachmentList(Integer pageSize, Integer pageNumber, Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumAttachmentList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获取贴子的附件列表
     *
     * @param forumId
     * @return
     */
    public List<AttachmentInfo> getAttachmentListByForumId(Integer forumId) throws IOException {
        return getCwmData().getIForumStrategy().getAttachmentListByForumId(forumId);
    }


    //endregion

}

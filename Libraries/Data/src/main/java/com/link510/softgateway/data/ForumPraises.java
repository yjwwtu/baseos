package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;
import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//论坛点赞表
@Service(value = "ForumPraisesData")
public class ForumPraises extends DataService {


    //region  论坛点赞表方法

    /**
     * 获得论坛点赞表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumPraiseCount(Specification<ForumPraiseInfo> condition) throws IOException {
        return getCwmData().getIForumStrategy().getForumPraiseCount(condition);
    }

    /**
     * 创建一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     * @return 返回创建信息
     **/
    public ForumPraiseInfo createForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException {
        return getCwmData().getIForumStrategy().createForumPraise(forumpraiseInfo);
    }

    /**
     * 更新一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     **/
    public ForumPraiseInfo updateForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException {
        return getCwmData().getIForumStrategy().updateForumPraise(forumpraiseInfo);
    }

    /**
     * 删除一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    public void deleteForumPraiseByPraiseId(Integer praiseId) throws IOException {
        getCwmData().getIForumStrategy().deleteForumPraiseByPraiseId(praiseId);
    }

    /**
     * 批量删除一批论坛点赞表数据
     **/
    public void deleteForumPraiseByPraiseIdList(String praiseIdList) throws IOException {
        getCwmData().getIForumStrategy().deleteForumPraiseByPraiseIdList(praiseIdList);
    }

    /**
     * 判断点赞
     *
     * @param forumId 帖子id
     * @param uid     用户uid
     * @return
     */

    public boolean isPraise(Integer forumId, Integer uid) throws IOException {
        return getCwmData().getIForumStrategy().isPraise(forumId, uid);
    }

    /**
     * 获取一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    public ForumPraiseInfo getForumPraiseByPraiseId(Integer praiseId) throws IOException {
        return getCwmData().getIForumStrategy().getForumPraiseByPraiseId(praiseId);
    }


    /**
     * 获得论坛点赞表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPraiseInfo
     **/
    public List<ForumPraiseInfo> getForumPraiseList(Specification<ForumPraiseInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumPraiseList(condition, sort);
    }


    /**
     * 获得论坛点赞表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPraiseInfo
     **/
    public Page<ForumPraiseInfo> getForumPraiseList(Integer pageSize, Integer pageNumber, Specification<ForumPraiseInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumPraiseList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}

package com.cqwo.xxx.services;

import com.cqwo.xxx.core.domain.forums.ForumPraiseInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.helper.DateHelper;
import com.cqwo.xxx.core.domain.forums.ForumPraiseInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.helper.DateHelper;
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

//论坛点赞表
@Service(value = "ForumPraises")
public class ForumPraises {
    @Resource(name = "ForumPraisesData")
    com.cqwo.xxx.data.ForumPraises forumPraises;


    @Autowired
    private Logs logs;

    //region  论坛点赞表方法

    /**
     * 获得论坛点赞表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumPraiseCount(Specification<ForumPraiseInfo> condition) {

        try {
            return forumPraises.getForumPraiseCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛点赞表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     * @return 返回创建信息
     **/
    public ForumPraiseInfo createForumPraise(ForumPraiseInfo forumpraiseInfo) {
        try {
            return forumPraises.createForumPraise(forumpraiseInfo);
        } catch (Exception ex) {
            logs.Write(ex, "创建一条论坛点赞表数据失败");
        }
        return null;
    }

    /**
     * 更新一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     **/
    public ForumPraiseInfo updateForumPraise(ForumPraiseInfo forumpraiseInfo) {
        try {
            return forumPraises.updateForumPraise(forumpraiseInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条论坛点赞表数据异常");
        }

        return null;
    }

    /**
     * 删除一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    public void deleteForumPraiseByPraiseId(Integer praiseId) {
        try {
            forumPraises.deleteForumPraiseByPraiseId(praiseId);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条论坛点赞表数据异常");
        }
    }

    /**
     * 批量删除一批论坛点赞表数据
     **/
    public void deleteForumPraiseByPraiseIdList(String praiseIdList) {
        try {
            forumPraises.deleteForumPraiseByPraiseIdList(praiseIdList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批论坛点赞表数据异常");
        }
    }


    /**
     * 判断点赞
     *
     * @param forumId 帖子id
     * @param uid     用户uid
     * @return
     */

    public boolean isPraise(Integer forumId, Integer uid) {

        boolean isSuccess = false;


        try {
            if (uid >= 1) {
                isSuccess = forumPraises.isPraise(forumId, uid);
            }
        } catch (Exception ex) {
            logs.Write(ex, "判断点赞");
        }

        return isSuccess;
    }

    /**
     * 获取一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    public ForumPraiseInfo getForumPraiseByPraiseId(Integer praiseId) {
        try {
            return forumPraises.getForumPraiseByPraiseId(praiseId);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条论坛点赞表数据");
        }

        return null;
    }


    /**
     * 获得论坛点赞表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPraiseInfo
     **/
    public List<ForumPraiseInfo> getForumPraiseList(Specification<ForumPraiseInfo> condition, Sort sort) {

        List<ForumPraiseInfo> forumPraiseList = new ArrayList<ForumPraiseInfo>();

        try {
            forumPraiseList = forumPraises.getForumPraiseList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛点赞表数据列表异常");
        }

        return forumPraiseList;
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
    public Page<ForumPraiseInfo> getForumPraiseList(Integer pageSize, Integer pageNumber, Specification<ForumPraiseInfo> condition, Sort sort) {

        Page<ForumPraiseInfo> forumPraiseList = null;

        try {
            forumPraiseList = forumPraises.getForumPraiseList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛点赞表数据列表异常");
        }

        return forumPraiseList;
    }


    /**
     * 用户点赞
     *
     * @param forumId
     * @param userInfo
     */
    public void clickPraise(Integer forumId, PartUserInfo userInfo) {

        try {

            Integer nowTime = DateHelper.getUnixTimeStamp();

            ForumPraiseInfo praiseInfo = new ForumPraiseInfo();

            praiseInfo.setForumId(forumId);

            praiseInfo.setUid(userInfo.getUid());
            praiseInfo.setNickName(userInfo.getNickName());
            praiseInfo.setPraiseTime(nowTime);

            createForumPraise(praiseInfo);

        } catch (Exception ex) {
            logs.Write(ex, "用户点赞失败");
        }

    }


    //endregion

}

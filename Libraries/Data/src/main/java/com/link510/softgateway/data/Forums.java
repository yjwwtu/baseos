package com.link510.softgateway.data;

import com.link510.softgateway.core.cache.CacheKeys;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.cache.CacheKeys;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqnews on 2017/4/11.
 */


//论坛主表
@Service(value = "ForumsData")
public class Forums extends DataService {


    //region  论坛主表方法

    /**
     * 获得论坛主表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumCount(Specification<ForumInfo> condition) throws IOException {
        return getCwmData().getIForumStrategy().getForumCount(condition);
    }

    /**
     * 创建一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     * @return 返回创建信息
     **/
    public ForumInfo createForum(ForumInfo forumInfo) throws IOException {
        return getCwmData().getIForumStrategy().createForum(forumInfo);
    }

    /**
     * 更新一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     **/
    public ForumInfo updateForum(ForumInfo forumInfo) throws IOException {
        return getCwmData().getIForumStrategy().updateForum(forumInfo);
    }

    /**
     * 删除一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    public void deleteForumByForumId(Integer forumId) throws IOException {
        getCwmData().getIForumStrategy().deleteForumByForumId(forumId);
    }

    /**
     * 批量删除一批论坛主表数据
     **/
    public void deleteForumByForumIdList(String forumIdList) throws IOException {
        getCwmData().getIForumStrategy().deleteForumByForumIdList(forumIdList);
    }

    /**
     * 获取一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    public ForumInfo getForumByForumId(Integer forumId) throws IOException {

        return getCwmData().getIForumStrategy().getForumByForumId(forumId);
    }


    /**
     * 获得论坛主表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumInfo
     **/
    public List<ForumInfo> getForumList(Specification<ForumInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumList(condition, sort);
    }


    /**
     * 获得论坛主表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumInfo
     **/
    public Page<ForumInfo> getForumList(Integer pageSize, Integer pageNumber, Specification<ForumInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIForumStrategy().getForumList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获取附近的发贴信息列表
     *
     * @return
     */
    public List<ForumInfo> getAroundForumList(Integer cateId, double longitude, double latitude, double dis) throws IOException {
        return getCwmData().getIForumStrategy().getAroundForumList(cateId, longitude, latitude, dis);
    }

    /**
     * 获取圈子首页列表
     *
     * @return
     */
    public List<ForumInfo> getHomeForumList() throws IOException{
        return getCwmData().getIForumStrategy().getHomeForumList();
    }

    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    public List<ForumInfo> getFindSpecieHomeForumList() throws IOException {

        List<ForumInfo> forumInfoList = getCwmCache().getIcachestrategy().getListValue(CacheKeys.FORUM_FINDSPECIE_HOME_FORUMLIST, ForumInfo.class);

        if (forumInfoList == null) {

            forumInfoList = getCwmData().getIForumStrategy().getFindSpecieHomeForumList();
            getCwmCache().getIcachestrategy().setListValue(CacheKeys.FORUM_FINDSPECIE_HOME_FORUMLIST, forumInfoList, 2, TimeUnit.MINUTES);

        }


        return forumInfoList;
    }

    /**
     * 获取列表生成条件
     *
     * @return
     * @param cateId
     */
    public Specification<ForumInfo> getForumListCondition(Integer cateId) throws IOException{
        return getCwmData().getIForumStrategy().getForumListCondition(cateId);
    }

    /**
     * 获取后台列表生成条件
     *
     * @param cateId
     * @return
     */
    public Specification<ForumInfo> getAdminForumListCondition(Integer cateId, String keywords) throws IOException {
        return getCwmData().getIForumStrategy().getAdminForumListCondition(cateId, keywords);
    }
    //endregion

}

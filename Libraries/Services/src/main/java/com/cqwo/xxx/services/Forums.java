package com.cqwo.xxx.services;

import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.helper.DateHelper;
import com.cqwo.xxx.core.helper.StringHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cqnews on 2017/4/11.
 */

//论坛主表
@Service(value = "Forums")
public class Forums {
    @Resource(name = "ForumsData")
    com.cqwo.xxx.data.Forums forums;

    private Lock lock = new ReentrantLock();

    @Autowired
    Categorys categorys;

    @Autowired
    private Logs logs;

    @Autowired
    private Users users;

    @Autowired
    private ForumPosts forumPosts;

    @Autowired
    private ForumAttachments forumAttachments;

    @Autowired
    private ForumPraises forumPraises;

    //region  论坛主表方法

    /**
     * 获得论坛主表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getForumCount(Specification<ForumInfo> condition) {

        try {
            return forums.getForumCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     * @return 返回创建信息
     **/
    public ForumInfo createForum(ForumInfo forumInfo) {
        try {
            return forums.createForum(forumInfo);
        } catch (Exception ex) {
            logs.Write(ex, "创建一条论坛主表数据失败");
        }
        return null;
    }

    /**
     * 更新一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     **/
    public ForumInfo updateForum(ForumInfo forumInfo) {
        try {
            return forums.updateForum(forumInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条论坛主表数据异常");
        }

        return null;
    }

    /**
     * 删除一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    public void deleteForumByForumId(Integer forumId) {
        try {
            forums.deleteForumByForumId(forumId);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条论坛主表数据异常");
        }
    }

    /**
     * 批量删除一批论坛主表数据
     **/
    public void deleteForumByForumIdList(String forumIdList) {
        try {
            forums.deleteForumByForumIdList(forumIdList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批论坛主表数据异常");
        }
    }

    /**
     * 获取一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    public ForumInfo getForumByForumId(Integer forumId) {
        try {
            return forums.getForumByForumId(forumId);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条论坛主表数据");
        }

        return null;
    }


    /**
     * 获得论坛主表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumInfo
     **/
    public List<ForumInfo> getForumList(Specification<ForumInfo> condition, Sort sort) {

        List<ForumInfo> forumList = new ArrayList<ForumInfo>();

        try {
            forumList = forums.getForumList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数据列表异常");
        }

        return forumList;
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
    public Page<ForumInfo> getForumList(Integer pageSize, Integer pageNumber, Specification<ForumInfo> condition, Sort sort) {

        Page<ForumInfo> forumList = null;

        try {
            forumList = forums.getForumList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数据列表异常");
        }

        return forumList;
    }


    /**
     * 获取附近的发贴信息列表
     *
     * @return
     */
    public List<ForumInfo> getAroundForumList(Integer cateId, double longitude, double latitude, double dis) {

        List<ForumInfo> forumList = new ArrayList<>();

        try {
            forumList = forums.getAroundForumList(cateId, longitude, latitude, dis);

            int size = forumList.size();

            for (int i = 0; i < size; ++i) {

                for (int n = i + 1; n < size; n++) {

                    ForumInfo forumInfo1 = forumList.get(i);
                    ForumInfo forumInfo2 = forumList.get(n);
                    //

                    double lat1 = forumInfo1.getLatitude() - latitude;
                    double lng1 = forumInfo1.getLatitude() - longitude;


                    double lat2 = forumInfo2.getLatitude() - latitude;
                    double lng2 = forumInfo2.getLatitude() - longitude;


                    if (lat1 + lng1 > lat2 + lng2) {

                        ForumInfo forumInfo3 = forumList.get(i);
                        forumList.set(i, forumList.get(n));
                        forumList.set(n, forumInfo3);
                    }

                    // System.out.println(forumList.get(n));

                }

                // System.out.println("下一个");

            }


        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数据列表异常");
        }

        return forumList;


    }

    /**
     * 获取圈子首页列表
     *
     * @return
     */
    public List<ForumInfo> getHomeForumList() {

        List<ForumInfo> forumList = new ArrayList<ForumInfo>();

        try {
            forumList = forums.getHomeForumList();
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数据列表异常");
        }

        return forumList;

    }

    /**
     * 获取贴子视图列表
     *
     * @param uid
     * @return
     */
    public List<ForumVisitInfo> getHomeForumVisitList(Integer uid) {

        List<ForumInfo> forumInfoList = getHomeForumList();

        List<ForumVisitInfo> forumVisitInfoList = new ArrayList<>();

        LoadVisitList(forumVisitInfoList, forumInfoList, uid);


        return forumVisitInfoList;
    }

    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    public List<ForumVisitInfo> getFindSpecieHomeForumVisitlist(Integer uid) {

        List<ForumInfo> forumInfoList = getFindSpecieHomeForumList();

        List<ForumVisitInfo> forumVisitInfoList = new ArrayList<>();

        LoadVisitList(forumVisitInfoList, forumInfoList, uid);


        return forumVisitInfoList;
    }


    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    public List<ForumInfo> getFindSpecieHomeForumList() {

        List<ForumInfo> forumList = new ArrayList<ForumInfo>();

        try {
            forumList = forums.getFindSpecieHomeForumList();
        } catch (Exception ex) {
            logs.Write(ex, "获得论坛主表数据列表异常");
        }

        return forumList;
    }

    /**
     * 装载视图访问列表项
     *
     * @param forumVisitInfoList 视图列表
     * @param forumInfoList      圈子列表
     */
    public void LoadVisitList(List<ForumVisitInfo> forumVisitInfoList, List<ForumInfo> forumInfoList, Integer uid) {

        if (forumVisitInfoList == null) {
            forumVisitInfoList = new ArrayList<>();
        }

        for (ForumInfo forumInfo : forumInfoList) {

            if (forumInfo == null || forumInfo.getForumId() <= 0) {
                continue;
            }

            ForumVisitInfo forumVisitInfo = LoadForumVisitInfo(forumInfo, uid);

            if (forumVisitInfo == null) {
                continue;
            }

            forumVisitInfoList.add(forumVisitInfo);

        }

    }

    /**
     * 处理视图
     *
     * @param forumInfo
     * @param uid
     * @return
     */
    public ForumVisitInfo LoadForumVisitInfo(ForumInfo forumInfo, int uid) {
        if (forumInfo == null || forumInfo.getForumId() <= 0) {
            return null;
        }

        Integer forumId = forumInfo.getForumId();

        Integer forumUid = forumInfo.getUid();

        Integer cateId = forumInfo.getCateId();


        /**
         * 圈子所属分类
         */
        CategoryInfo forumCategoryInfo = categorys.getCategoryByCateId(cateId);


        /**
         * 发贴人信息
         */
        PartUserInfo userInfo = users.getPartUserByUid(forumUid);


        /**
         * 最新回复
         */
        List<ForumPostInfo> forumPostInfoList = forumPosts.getNewForumPostList(forumId, 3);

        /**
         * 附件列表
         */
        List<AttachmentInfo> forumAttachmentInfoList = forumAttachments.getAttachmentListByForumId(forumId);


        boolean isPraise = forumPraises.isPraise(forumId, uid);


        ForumVisitInfo forumVisitInfo = new ForumVisitInfo(forumId,
                forumInfo,
                forumCategoryInfo,
                userInfo,
                forumPostInfoList, forumAttachmentInfoList, isPraise);

        return forumVisitInfo;

    }

    /**
     * 获取列表生成条件
     *
     * @param cateId
     * @return
     */
    public Specification<ForumInfo> getForumListCondition(Integer cateId) {

        Specification<ForumInfo> condition = null;

        try {

            condition = forums.getForumListCondition(cateId);

        } catch (Exception ex) {

            logs.Write(ex, "获取列表生成条件");
        }

        return condition;

    }


    /**
     * 获取后台列表生成条件
     *
     * @param cateId
     * @return
     */
    public Specification<ForumInfo> getAdminForumListCondition(Integer cateId, String keywords) {
        Specification<ForumInfo> condition = null;

        try {

            condition = forums.getAdminForumListCondition(cateId, keywords);

        } catch (Exception ex) {

            logs.Write(ex, "获取列表生成条件");
        }

        return condition;
    }

    /**
     * 朋友圈发贴
     *
     * @param categoryInfo 分类信息
     * @param body         内容
     * @param at           提醒关注
     * @param latitude     纬度
     * @param longitude    经度
     * @param address      地址
     * @param mediaUrl     视频地址
     * @param imgUrlList   图片列表
     * @return
     */
    public ForumInfo sendForum(PartUserInfo userInfo, CategoryInfo categoryInfo, String body, String at, double latitude, double longitude, String address, String mediaUrl, List<String> imgUrlList) {

        lock.lock();
        try {

            Integer nowTime = DateHelper.getUnixTimeStamp();


            ForumInfo forumInfo = new ForumInfo();


            forumInfo.setCateId(categoryInfo.getCateId());
            forumInfo.setCateName(categoryInfo.getName());

            forumInfo.setUid(userInfo.getUid());
            forumInfo.setNickName(userInfo.getNickName());

            forumInfo.setAt(at);

            forumInfo.setLatitude(latitude);
            forumInfo.setLongitude(longitude);
            forumInfo.setAddress(address);

            forumInfo.setBody(body);

            forumInfo.setTitle(StringHelper.getStringTitle(body, 20));
            forumInfo.setIsNew(1);

            Integer newExpireTime = DateHelper.addDayToUnixTime(7);

            forumInfo.setNewExpireTime(newExpireTime);

            forumInfo.setMediaUrl(mediaUrl);
            if (imgUrlList.size() >= 1) {
                forumInfo.setLitpic(imgUrlList.get(0));
            }
            forumInfo.setIsShow(1);


            forumInfo.setAddTime(nowTime);
            forumInfo.setUpdateTime(nowTime);

            ForumInfo newForumInfo = createForum(forumInfo);

            if (newForumInfo != null && newForumInfo.getForumId() >= 1) {

                if (imgUrlList.size() >= 1) {
                    forumAttachments.createForumAttachment(imgUrlList, newForumInfo);
                }


                return newForumInfo;
            }


        } catch (Exception ex) {

            logs.Write(ex, "用户发贴失败");
            throw ex;

        } finally {
            lock.unlock();
        }

        return null;


    }


    //endregion


    @Test
    public void Test2() {

        Integer time = Math.toIntExact(DateHelper.addDay(7).getTime() / 1000);

        System.out.println(time);
        System.out.println(DateHelper.addDay(7).getTime());
    }


}


package com.cqwo.xxx.core.data.rdbs.repository.fourms;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ForumRepository extends BaseRepository<ForumInfo, Integer> {


    /**
     * 获取圈子首页列表
     *
     * @return
     */
    @Query("select forum FROM ForumInfo forum where forum.isShow = 1 and (forum.isHot = 1 or forum.isTop = 1)")
    List<ForumInfo> getHomeForumList();

    /**
     * 更新统计数
     *
     * @param forumId 贴子id
     */
    @Modifying
    @Transactional
    @Query("update ForumInfo set postCount = (select count(forumId) from ForumPostInfo where forumId = ?1) where forumId = ?1")
    void updatePostCount(Integer forumId);


    @Modifying
    @Transactional
    @Query("update ForumInfo  set praiseCount = (select count(forumId) from ForumPraiseInfo where forumId = ?1) where forumId = ?1")
    void updatePraiseCount(Integer forumId);


    /**
     * 获取用户分类
     *
     * @param typeId
     * @return
     */
    @Query("select info from ForumInfo info where exists (select 1 from CategoryInfo cateinfo where info.cateId = cateinfo.cateId and cateinfo.typeId = ?1)")
    List<ForumInfo> getForumListByTypeId(Integer typeId);
}
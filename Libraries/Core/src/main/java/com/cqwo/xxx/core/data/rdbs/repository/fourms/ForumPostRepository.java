
package com.cqwo.xxx.core.data.rdbs.repository.fourms;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;

import java.util.List;

public interface ForumPostRepository extends BaseRepository<ForumPostInfo, Integer> {


    /**
     * 获取当前帖子的列表
     *
     * @param forumId
     * @return
     */
    List<ForumInfo> findByForumId(Integer forumId);

    /**
     * 统计论坛的回帖数量
     *
     * @param forumId
     * @return
     */
    long countByForumId(Integer forumId);
}
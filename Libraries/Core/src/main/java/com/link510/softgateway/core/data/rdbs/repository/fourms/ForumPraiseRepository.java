
package com.link510.softgateway.core.data.rdbs.repository.fourms;

import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;

public interface ForumPraiseRepository extends BaseRepository<ForumPraiseInfo, Integer> {


    /**
     * 判断点赞
     * @param forumId
     * @param uid
     * @return
     */
    boolean existsByForumIdAndUid(Integer forumId, Integer uid);

}
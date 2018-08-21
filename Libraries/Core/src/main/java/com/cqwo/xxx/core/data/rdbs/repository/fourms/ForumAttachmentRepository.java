
package com.cqwo.xxx.core.data.rdbs.repository.fourms;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.forums.ForumAttachmentInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForumAttachmentRepository extends BaseRepository<ForumAttachmentInfo, Integer> {

    /**
     * 获取贴子的附件列表
     *
     * @param forumId
     * @return
     */
    List<ForumAttachmentInfo> findByForumId(Integer forumId);


    /**
     * 获取附件列表
     *
     * @param forumId
     * @return
     */
    @Transactional
    @Query("select info from AttachmentInfo info where  exists (select 1 from ForumAttachmentInfo forminfo where forminfo.forumId = ?1 and  forminfo.attachId = info.attachId)")
    List<AttachmentInfo> getAttachmentListByForumId(Integer forumId);


//    @Transactional
//    @Query(value = "INSERT INTO ForumAttachmentInfo foruminfo (attachId,forumId) SELECT findinfo.attachId,?2 FROM FindAttachmentInfo findinfo WHERE findinfo.findId = ?1",nativeQuery = true)
//    @Modifying
//    void createForumAttachmentFromFindAttachment(Integer findId, Integer forumId);
}
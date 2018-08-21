
package com.cqwo.xxx.core.data.rdbs.repository.authors;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.authors.AuthorActionInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorActionRepository extends BaseRepository<AuthorActionInfo, Integer> {

    /**
     * 获取角色的分组信息
     *
     * @param roleId
     */
    @Query("SELECT action FROM AuthorActionInfo action where exists (SELECT 1 FROM AuthorPermissionInfo authorpermission where action.aid = authorpermission.aid and authorpermission.roleId = ?1)")
    List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId);
}
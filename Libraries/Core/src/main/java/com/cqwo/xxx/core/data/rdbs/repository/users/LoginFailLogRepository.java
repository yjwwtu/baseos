package com.cqwo.xxx.core.data.rdbs.repository.users;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.users.LoginFailLogInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LoginFailLogRepository extends BaseRepository<LoginFailLogInfo, Integer> {

    @Query("DELETE FROM LoginFailLogInfo where loginIP=?1")
    @Modifying
    @Transactional
    void deleteLoginFailLogByIP(Integer ip);
}

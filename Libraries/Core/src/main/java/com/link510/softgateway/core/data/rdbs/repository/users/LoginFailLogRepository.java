package com.link510.softgateway.core.data.rdbs.repository.users;

import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.domain.users.LoginFailLogInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LoginFailLogRepository extends BaseRepository<LoginFailLogInfo, Integer> {

    @Query("DELETE FROM LoginFailLogInfo where loginIP=?1")
    @Modifying
    @Transactional
    void deleteLoginFailLogByIP(Integer ip);
}

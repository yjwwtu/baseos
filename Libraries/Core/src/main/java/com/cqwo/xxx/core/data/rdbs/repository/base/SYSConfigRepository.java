
package com.cqwo.xxx.core.data.rdbs.repository.base;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.base.SYSConfigInfo;

public interface SYSConfigRepository extends BaseRepository<SYSConfigInfo, Integer> {

    /**
     * 找用户名
     * @param name
     * @return
     */
    SYSConfigInfo findByVarName(String name);


}

package com.link510.softgateway.core.data.rdbs.repository.base;

import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.domain.base.SYSConfigInfo;

public interface SYSConfigRepository extends BaseRepository<SYSConfigInfo, Integer> {

    /**
     * 找用户名
     * @param name
     * @return
     */
    SYSConfigInfo findByVarName(String name);


}
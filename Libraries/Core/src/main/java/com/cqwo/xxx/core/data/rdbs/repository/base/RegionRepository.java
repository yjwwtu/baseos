package com.cqwo.xxx.core.data.rdbs.repository.base;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.base.RegionInfo;

public interface RegionRepository extends BaseRepository<RegionInfo, Integer> {

    Integer countByRegionId(Integer regionId);

}

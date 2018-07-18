package com.link510.softgateway.core.data.rdbs.repository.base;

import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.domain.base.RegionInfo;

public interface RegionRepository extends BaseRepository<RegionInfo, Integer> {

    Integer countByRegionId(Integer regionId);

}

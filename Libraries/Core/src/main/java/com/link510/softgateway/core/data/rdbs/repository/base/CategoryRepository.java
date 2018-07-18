
package com.link510.softgateway.core.data.rdbs.repository.base;

import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.data.rdbs.repository.BaseRepository;
import com.link510.softgateway.core.domain.base.CategoryInfo;

import java.util.List;

public interface CategoryRepository extends BaseRepository<CategoryInfo, Integer> {

    /**
     * 获得发现分类数据列表
     *
     * @param typeId
     * @param parentId
     * @return
     */
    List<CategoryInfo> findByTypeIdAndParentId(Integer typeId, Integer parentId);

    /**
     * 获取分类列表
     *
     * @param typeId
     * @return
     */
    List<CategoryInfo> findByTypeId(Integer typeId);
}

package com.cqwo.xxx.core.data.rdbs.repository.banks;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;

public interface BankRollRepository extends BaseRepository<BankRollInfo, Integer> {

//    /**
//     * 流水审核
//     *
//     * @param id        流水id
//     * @param state     流水状态
//     * @param actionDes 状态描述
//     * @return
//     */
//    @Query("update BankRollInfo info set info.state = ?2,info.description = ?3 where info.id = ?1")
//    void updateBankState(Integer id, Integer state, String actionDes, Integer actionTime);
}
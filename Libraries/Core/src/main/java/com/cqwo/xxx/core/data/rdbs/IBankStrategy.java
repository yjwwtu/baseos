package com.cqwo.xxx.core.data.rdbs;

import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.banks.BankRollLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;

public interface IBankStrategy {


    //region 用户流水

    /**
     * 获得用户流水数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getBankRollCount(Specification<BankRollInfo> condition) throws IOException;


    /**
     * 创建一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     * @return 返回创建信息
     **/
    BankRollInfo createBankRoll(BankRollInfo bankrollInfo) throws IOException;


    /**
     * 更新一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     **/
    BankRollInfo updateBankRoll(BankRollInfo bankrollInfo) throws IOException;

    /**
     * 删除一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    void deleteBankRollById(int id) throws IOException;

    /**
     * 批量删除一批用户流水数据
     **/
    void deleteBankRollByIdList(String idList) throws IOException;


    /**
     * 获得用户流水一条记录
     *
     * @param id id
     * @return 返回一条BankRollInfo
     **/
    BankRollInfo getBankRollById(int id) throws IOException;

    /**
     * 获得用户流水数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollInfo
     **/
    List<BankRollInfo> getBankRollList(Specification<BankRollInfo> condition, Sort sort) throws IOException;


    /**
     * 获得用户流水数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BankRollInfo
     **/
    Page<BankRollInfo> getBankRollList(Integer pageSize, Integer pageNumber, Specification<BankRollInfo> condition, Sort sort) throws IOException;


    /**
     * 获取用户流水
     *
     * @param uid   用户uid
     * @param state 流水状态
     * @return
     */
    Specification<BankRollInfo> getUserBankRollListCondition(Integer uid, Integer state) throws IOException;


    /**
     * 发起提现
     *
     * @param bankInfo
     * @return
     */
    BankRollInfo sendCash(BankRollInfo bankInfo) throws IOException;

    /**
     * 流水审核
     *
     * @param id        流水id
     * @param state     流水状态
     * @param actionDes 描述
     * @param operator  操作人
     * @return
     */
    boolean updateBankState(Integer id, Integer state, String actionDes, Integer operator) throws IOException;

    //endregion 用户流水结束

    //region 流水日志记录

    /**
     * 获得流水日志记录数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getBankRollLogCount(Specification<BankRollLogInfo> condition) throws IOException;


    /**
     * 创建一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     * @return 返回创建信息
     **/
    BankRollLogInfo createBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException;


    /**
     * 更新一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     **/
    BankRollLogInfo updateBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException;

    /**
     * 删除一条流水日志记录数据
     *
     * @param logId 流水日志记录模型
     **/
    void deleteBankRollLogByLogId(int logId) throws IOException;

    /**
     * 批量删除一批流水日志记录数据
     **/
    void deleteBankRollLogByLogIdList(String logIdList) throws IOException;


    /**
     * 获得流水日志记录一条记录
     *
     * @param logId iogid
     * @return 返回一条BankRollLogInfo
     **/
    BankRollLogInfo getBankRollLogByLogId(int logId) throws IOException;

    /**
     * 获得流水日志记录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollLogInfo
     **/
    List<BankRollLogInfo> getBankRollLogList(Specification<BankRollLogInfo> condition, Sort sort) throws IOException;


    /**
     * 获得流水日志记录数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BankRollLogInfo
     **/
    Page<BankRollLogInfo> getBankRollLogList(Integer pageSize, Integer pageNumber, Specification<BankRollLogInfo> condition, Sort sort) throws IOException;


    //endregion 流水日志记录结束
}

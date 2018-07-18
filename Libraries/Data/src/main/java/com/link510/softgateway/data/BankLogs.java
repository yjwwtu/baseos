package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.banks.BankRollLogInfo;
import com.link510.softgateway.core.domain.banks.BankRollLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//流水日志记录
@Service(value = "BankLogsData")
public class BankLogs extends DataService {


    //region  流水日志记录方法

    /**
     * 获得流水日志记录数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getBankRollLogCount(Specification<BankRollLogInfo> condition) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollLogCount(condition);
    }

    /**
     * 创建一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     * @return 返回创建信息
     **/
    public BankRollLogInfo createBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException {
        return getCwmData().getIBankStrategy().createBankRollLog(bankrolllogInfo);
    }

    /**
     * 更新一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     **/
    public BankRollLogInfo updateBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException {
        return getCwmData().getIBankStrategy().updateBankRollLog(bankrolllogInfo);
    }

    /**
     * 删除一条流水日志记录数据
     *
     * @param logId 流水日志记录模型
     **/
    public void deleteBankRollLogByLogId(int logId) throws IOException {
        getCwmData().getIBankStrategy().deleteBankRollLogByLogId(logId);
    }

    /**
     * 批量删除一批流水日志记录数据
     **/
    public void deleteBankRollLogByLogIdList(String logIdList) throws IOException {
        getCwmData().getIBankStrategy().deleteBankRollLogByLogIdList(logIdList);
    }

    /**
     * 获取一条流水日志记录数据
     *
     * @param logId 流水日志记录模型
     **/
    public BankRollLogInfo getBankRollLogByLogId(int logId) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollLogByLogId(logId);
    }


    /**
     * 获得流水日志记录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollLogInfo
     **/
    public List<BankRollLogInfo> getBankRollLogList(Specification<BankRollLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollLogList(condition, sort);
    }


    /**
     * 获得流水日志记录数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BankRollLogInfo
     **/
    public Page<BankRollLogInfo> getBankRollLogList(Integer pageSize, Integer pageNumber, Specification<BankRollLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollLogList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}

package com.cqwo.xxx.services;

import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.banks.BankRollLogInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.enums.bank.BankAction;
import com.cqwo.xxx.core.enums.bank.BankState;
import com.cqwo.xxx.core.helper.DateHelper;
import com.cqwo.xxx.data.BankLogs;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.banks.BankRollLogInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.enums.bank.BankAction;
import com.cqwo.xxx.core.enums.bank.BankState;
import com.cqwo.xxx.core.helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cqnews on 2017/4/11.
 */

//用户流水
@Service(value = "BankRolls")
public class Banks {


    private Lock lock = new ReentrantLock();

    @Resource(name = "BanksData")
    com.cqwo.xxx.data.Banks banks;

    @Resource(name = "BankLogsData")
    BankLogs bankLogs;


    @Autowired
    private Logs logs;

    //region  用户流水方法

    /**
     * 获得用户流水数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getBankRollCount(Specification<BankRollInfo> condition) {

        try {
            return banks.getBankRollCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得用户流水数量失败");
        }
        return 0;
    }

//    /**
//     * 创建一条用户流水数据
//     *
//     * @param bankrollInfo 用户流水模型
//     * @return 返回创建信息
//     **/
//    public BankRollInfo createBankRoll(BankRollInfo bankrollInfo) throws IOException {
//        try {
//            return banks.createBankRoll(bankrollInfo);
//        } catch (Exception ex) {
//
//            logs.write(ex, "创建一条用户流水数据失败");
//
//        }
//
//        return null;
//    }

    /**
     * 更新一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     **/
    public BankRollInfo updateBankRoll(BankRollInfo bankrollInfo) {
        try {
            return banks.updateBankRoll(bankrollInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条用户流水数据异常");
        }

        return null;
    }

    /**
     * 删除一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    public void deleteBankRollById(int id) {
        try {
            banks.deleteBankRollById(id);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条用户流水数据异常");
        }
    }

    /**
     * 批量删除一批用户流水数据
     **/
    public void deleteBankRollByIdList(String idList) {
        try {
            banks.deleteBankRollByIdList(idList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批用户流水数据异常");
        }
    }

    /**
     * 获取一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    public BankRollInfo getBankRollById(int id) {
        try {
            return banks.getBankRollById(id);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条用户流水数据");
        }

        return null;
    }


    /**
     * 获得用户流水数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollInfo
     **/
    public List<BankRollInfo> getBankRollList(Specification<BankRollInfo> condition, Sort sort) {

        List<BankRollInfo> bankrollList = new ArrayList<BankRollInfo>();

        try {
            bankrollList = banks.getBankRollList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得用户流水数据列表异常");
        }

        return bankrollList;
    }


    /**
     * 获得用户流水数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BankRollInfo
     **/
    public Page<BankRollInfo> getBankRollList(Integer pageSize, Integer pageNumber, Specification<BankRollInfo> condition, Sort sort) {

        Page<BankRollInfo> bankrollList = null;

        try {

            bankrollList = banks.getBankRollList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得用户流水数据列表异常");
        }

        return bankrollList;
    }


    //endregion


    //region  流水日志记录方法

    /**
     * 获得流水日志记录数量
     * @param condition 条件
     * @return 返回数量
     **/
    public long getBankRollLogCount(Specification<BankRollLogInfo> condition) {

        try {
            return bankLogs.getBankRollLogCount(condition);
        } catch (Exception ex) {
            logs.Write(ex, "获得流水日志记录数量失败");
        }
        return 0;
    }

    /**
     * 创建一条流水日志记录数据
     * @param bankrolllogInfo 流水日志记录模型
     * @return 返回创建信息
     **/
    public BankRollLogInfo createBankRollLog(BankRollLogInfo bankrolllogInfo) {
        try {
            return bankLogs.createBankRollLog(bankrolllogInfo);
        } catch (Exception ex) {
            logs.Write(ex, "创建一条流水日志记录数据失败");
        }
        return null;
    }

    /**
     * 更新一条流水日志记录数据
     * @param bankrolllogInfo 流水日志记录模型
     **/
    public BankRollLogInfo updateBankRollLog(BankRollLogInfo bankrolllogInfo) {
        try {
            return bankLogs.updateBankRollLog(bankrolllogInfo);
        } catch (Exception ex) {
            logs.Write(ex, "更新一条流水日志记录数据异常");
        }

        return null;
    }

    /**
     * 删除一条流水日志记录数据
     * @param logId 流水日志记录模型
     **/
    public void deleteBankRollLogByLogId(int logId) {
        try {
            bankLogs.deleteBankRollLogByLogId(logId);
        } catch (Exception ex) {
            logs.Write(ex, "删除一条流水日志记录数据异常");
        }
    }
    /**
     * 批量删除一批流水日志记录数据
     **/
    public void deleteBankRollLogByLogIdList(String logIdList) {
        try {
            bankLogs.deleteBankRollLogByLogIdList(logIdList);
        } catch (Exception ex) {
            logs.Write(ex, "批量删除一批流水日志记录数据异常");
        }
    }

    /**
     * 获取一条流水日志记录数据
     * @param logId 流水日志记录模型
     **/
    public BankRollLogInfo getBankRollLogByLogId(int logId) {
        try {
            return bankLogs.getBankRollLogByLogId(logId);
        } catch (Exception ex) {
            logs.Write(ex, "获取一条流水日志记录数据");
        }

        return null;
    }




    /**
     * 获得流水日志记录数据列表
     * @param condition 条件
     * @param sort 排序
     * @return 返回BankRollLogInfo
     **/
    public List<BankRollLogInfo> getBankRollLogList(Specification<BankRollLogInfo> condition, Sort sort) {

        List<BankRollLogInfo> bankrollLogList = new ArrayList<BankRollLogInfo>();

        try {
            bankrollLogList = bankLogs.getBankRollLogList(condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得流水日志记录数据列表异常");
        }

        return bankrollLogList;
    }



    /**
     * 获得流水日志记录数据列表
     * @param pageSize 每页数
     * @param pageNumber 当前页数
     * @param condition 条件
     * @param sort 排序
     * @return 返回BankRollLogInfo
     **/
    public Page<BankRollLogInfo> getBankRollLogList(Integer pageSize, Integer pageNumber, Specification<BankRollLogInfo> condition, Sort sort) {

        Page<BankRollLogInfo> bankrollLogList = null;

        try {
            bankrollLogList = bankLogs.getBankRollLogList(pageSize, pageNumber, condition, sort);
        } catch (Exception ex) {
            logs.Write(ex, "获得流水日志记录数据列表异常");
        }

        return bankrollLogList;
    }

    /**
     * @param state
     * @return
     */
    public Specification<BankRollInfo> getBankRollListCondition(Integer state) {
        return null;
    }


    /**
     * 获取用户流水条件
     *
     * @param uid
     * @param state
     * @return
     */
    public Specification<BankRollInfo> getUserBankRollListCondition(Integer uid, Integer state) {

        Specification<BankRollInfo> condition = null;

        try {

            condition = banks.getUserBankRollListCondition(uid, state);

        } catch (Exception ex) {

        }

        return condition;

    }

    /**
     * 用户申请提现
     *
     * @param userInfo
     * @param money
     * @return
     */
    public BankRollInfo sendCash(PartUserInfo userInfo, double money) {

        try {

            if (userInfo.getMoney() < money) {
                return null;
            }

            BankRollInfo bankInfo = new BankRollInfo();

            Integer nows = DateHelper.getUnixTimeStamp();

            bankInfo.setUid(userInfo.getUid());
            bankInfo.setBankAction(BankAction.Cash.getIndex());
            bankInfo.setOperator(bankInfo.getUid());
            bankInfo.setMoney(money);
            bankInfo.setCommission(money * 0.00);
            bankInfo.setFactMoney(bankInfo.getMoney() - bankInfo.getCommission());

            bankInfo.setAddTime(nows);
            bankInfo.setUpdateTime(nows);
            bankInfo.setCompleteTime(nows);

            bankInfo.setDescription("用户提现");
            bankInfo.setBody("用户提现");
            bankInfo.setState(BankState.Submitted.getIndex());

            logs.Write(bankInfo.toString());

            return banks.sendCash(bankInfo);


        } catch (Exception ex) {

            //throw ex;
            logs.Write(ex, "用户申请提现失败");

        } finally {
        }

        return null;

    }


    /**
     * 流水审核
     *
     * @param id        流水id
     * @param actionDes 操作描述
     * @param operator  操作人
     * @return
     */
    public boolean confirm(Integer id, String actionDes, Integer operator) {

        boolean isSuccess = false;

        try {

            isSuccess = banks.updateBankState(id, BankState.Confirming.getIndex(), actionDes, operator);

        } catch (Exception ex) {

            logs.Write(ex, "流水审核失败");
        }

        return isSuccess;

    }

    /**
     * 锁定流水
     *
     * @param id        流水id
     * @param actionDes 操作描述
     * @param operator  操作人
     * @return
     */
    public boolean locked(Integer id, String actionDes, Integer operator) {

        boolean isSuccess = false;

        try {

            isSuccess = banks.updateBankState(id, BankState.Locked.getIndex(), actionDes, operator);

        } catch (Exception ex) {

            logs.Write(ex, "锁定流水失败");
        }

        return isSuccess;
    }


    /**
     * 取消流水
     *
     * @param id        流水id
     * @param actionDes 操作描述
     * @param operator  操作人
     * @return
     */
    public boolean cancelled(Integer id, String actionDes, Integer operator) {

        boolean isSuccess = false;

        try {

            isSuccess = banks.updateBankState(id, BankState.Cancelled.getIndex(), actionDes, operator);

        } catch (Exception ex) {

            logs.Write(ex, "锁定流水失败");
        }

        return isSuccess;
    }

    /**
     * 取消流水
     *
     * @param id        操作流水id
     * @param actionDes 操作描述
     * @param operator  操作人
     * @return
     */
    public boolean returned(Integer id, String actionDes, Integer operator) {

        boolean isSuccess = false;

        try {

            isSuccess = banks.updateBankState(id, BankState.Returned.getIndex(), actionDes, operator);

        } catch (Exception ex) {

            logs.Write(ex, "锁定流水失败");
        }

        return isSuccess;
    }

    /**
     * 用户提现到账
     *
     * @param id       流水id
     * @param operator 操作人
     * @return
     */
    public boolean cashCompleted(Integer id, String actionDes, Integer operator) {

        boolean isSuccess = false;

        try {

            banks.updateBankState(id, BankState.Completed.getIndex(), actionDes, operator);

        } catch (Exception ex) {

            logs.Write("用户提现到账处理");
        }

        return isSuccess;

    }


    //endregion

}

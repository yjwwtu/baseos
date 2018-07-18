package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//用户流水
@Service(value = "BanksData")
public class Banks extends DataService {


    //region  用户流水方法

    /**
     * 获得用户流水数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getBankRollCount(Specification<BankRollInfo> condition) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollCount(condition);
    }

//    /**
//     * 创建一条用户流水数据
//     *
//     * @param bankrollInfo 用户流水模型
//     * @return 返回创建信息
//     **/
//    public BankRollInfo createBankRoll(BankRollInfo bankrollInfo) throws IOException {
//        return getCwmData().getIBankStrategy().createBankRoll(bankrollInfo);
//    }

    /**
     * 更新一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     **/
    public BankRollInfo updateBankRoll(BankRollInfo bankrollInfo) throws IOException {
        return getCwmData().getIBankStrategy().updateBankRoll(bankrollInfo);
    }

    /**
     * 删除一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    public void deleteBankRollById(int id) throws IOException {
        getCwmData().getIBankStrategy().deleteBankRollById(id);
    }

    /**
     * 批量删除一批用户流水数据
     **/
    public void deleteBankRollByIdList(String idList) throws IOException {
        getCwmData().getIBankStrategy().deleteBankRollByIdList(idList);
    }

    /**
     * 获取一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    public BankRollInfo getBankRollById(int id) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollById(id);
    }


    /**
     * 获得用户流水数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollInfo
     **/
    public List<BankRollInfo> getBankRollList(Specification<BankRollInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollList(condition, sort);
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
    public Page<BankRollInfo> getBankRollList(Integer pageSize, Integer pageNumber, Specification<BankRollInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBankStrategy().getBankRollList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获取用户流水
     *
     * @param uid   用户uid
     * @param state 流水状态
     * @return
     */
    public Specification<BankRollInfo> getUserBankRollListCondition(Integer uid, Integer state) throws IOException {
        return getCwmData().getIBankStrategy().getUserBankRollListCondition(uid, state);
    }


    /**
     * 发起提现
     *
     * @param bankInfo
     * @return
     */
    public BankRollInfo sendCash(BankRollInfo bankInfo) throws IOException {
        return getCwmData().getIBankStrategy().sendCash(bankInfo);
    }

    /**
     * 流水审核
     *
     * @param id        流水id
     * @param state     流水状态
     * @param actionDes 描述
     * @param operator  操作人
     * @return
     */
    public boolean updateBankState(Integer id, Integer state, String actionDes, Integer operator) throws IOException {
        return getCwmData().getIBankStrategy().updateBankState(id, state, actionDes, operator);
    }


    //endregion

}

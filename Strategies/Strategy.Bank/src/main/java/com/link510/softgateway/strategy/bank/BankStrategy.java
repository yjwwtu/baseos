package com.link510.softgateway.strategy.bank;

import com.link510.softgateway.core.data.rdbs.IBankStrategy;
import com.link510.softgateway.core.data.rdbs.repository.banks.BankRollLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.banks.BankRollRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.UserRepository;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.banks.BankRollLogInfo;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.core.data.rdbs.IBankStrategy;
import com.link510.softgateway.core.data.rdbs.repository.banks.BankRollLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.banks.BankRollRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.UserRepository;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.banks.BankRollLogInfo;
import com.link510.softgateway.core.helper.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component(value = "BankRollStrategy")
public class BankStrategy implements IBankStrategy {

    @Autowired
    BankRollRepository bankRollRepository;

    @Autowired
    private UserRepository userRepository;

    //region 用户流水		 

    /**
     * 获得用户流水数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getBankRollCount(Specification<BankRollInfo> condition) throws IOException {

        return bankRollRepository.count();
    }


    /**
     * 创建一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public BankRollInfo createBankRoll(BankRollInfo bankrollInfo) throws IOException {

        BankRollInfo bankinfo = bankRollRepository.save(bankrollInfo);


        BankRollLogInfo logInfo = new BankRollLogInfo(bankinfo);

        createBankRollLog(logInfo);

        return bankinfo;
    }


    /**
     * 更新一条用户流水数据
     *
     * @param bankrollInfo 用户流水模型
     **/
    @Override
    @Transactional
    public BankRollInfo updateBankRoll(BankRollInfo bankrollInfo) throws IOException {

        if (bankrollInfo.getId() >= 1)
            return bankRollRepository.save(bankrollInfo);

        return bankrollInfo;

    }


    /**
     * 删除一条用户流水数据
     *
     * @param id 用户流水模型
     **/
    @Override
    @Transactional
    public void deleteBankRollById(int id) throws IOException {

        bankRollRepository.deleteById(id);
    }

    /**
     * 批量删除一批用户流水数据
     **/
    public void deleteBankRollByIdList(String idlist) throws IOException {


    }

    /**
     * 获得用户流水一条记录
     *
     * @param id id
     * @return 返回一条BankRollInfo
     **/
    @Override
    @Transactional
    public BankRollInfo getBankRollById(int id) throws IOException {
        return bankRollRepository.findById(id).get();
    }


    /**
     * 获得用户流水数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollInfo
     **/
    @Override
    @Transactional
    public List<BankRollInfo> getBankRollList(Specification<BankRollInfo> condition, Sort sort) throws IOException {

        return bankRollRepository.findAll(condition, sort);

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
    @Override
    @Transactional
    public Page<BankRollInfo> getBankRollList(Integer pageSize, Integer pageNumber, Specification<BankRollInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");


        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return bankRollRepository.findAll(condition, pageable);


    }

    /**
     * 获取用户流水
     *
     * @param uid   用户uid
     * @param state 流水状态
     * @return
     */
    @Override
    @Transactional
    public Specification<BankRollInfo> getUserBankRollListCondition(Integer uid, Integer state) throws IOException {

        Specification<BankRollInfo> condition = new Specification<BankRollInfo>() {
            @Override
            public Predicate toPredicate(Root<BankRollInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<>();

                list.add(cb.equal(root.get("uid").as(Integer.class), uid));

                if (state >= 10) {

                    list.add(cb.equal(root.get("state").as(Integer.class), state));
                }

                Predicate[] p = new Predicate[list.size()];

                query.where(cb.and(list.toArray(p)));

                return query.getGroupRestriction();
            }
        };

        return condition;

    }

    /**
     * 发起提现
     *
     * @param bankInfo bank
     * @return
     */
    @Override
    @Transactional
    public BankRollInfo sendCash(BankRollInfo bankInfo) throws IOException {

        BankRollInfo bankRollInfo = bankRollRepository.save(bankInfo);

        BankRollLogInfo bankRollLogInfo = new BankRollLogInfo(bankRollInfo);

        bankRollLogRepository.save(bankRollLogInfo);

        userRepository.updateUserMoneyByUid(bankRollInfo.getUid(), bankRollInfo.getMoney() * -1.000000);

        return bankRollInfo;

    }

    /**
     * 流水状态更新,只是更新状态
     *
     * @param id        流水id
     * @param state     流水状态
     * @param actionDes 描述
     * @param operator  操作人
     * @return
     */
    @Override
    @Transactional
    public boolean updateBankState(Integer id, Integer state, String actionDes, Integer operator) throws IOException {

        Integer actionTime = DateHelper.getUnixTimeStamp();

        BankRollInfo bankRollInfo = getBankRollById(id);

        bankRollInfo.setState(state);
        bankRollInfo.setDescription(actionDes);
        bankRollInfo.setUpdateTime(actionTime);


        bankRollInfo = updateBankRoll(bankRollInfo);

        BankRollLogInfo bankRollLogInfo = new BankRollLogInfo(bankRollInfo);

        createBankRollLog(bankRollLogInfo);

        return true;
    }

    //endregion

    @Autowired
    BankRollLogRepository bankRollLogRepository;

    //region 流水日志记录

    /**
     * 获得流水日志记录数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getBankRollLogCount(Specification<BankRollLogInfo> condition) throws IOException {

        return bankRollLogRepository.count();
    }


    /**
     * 创建一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public BankRollLogInfo createBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException {

        return bankRollLogRepository.save(bankrolllogInfo);
    }


    /**
     * 更新一条流水日志记录数据
     *
     * @param bankrolllogInfo 流水日志记录模型
     **/
    @Override
    @Transactional
    public BankRollLogInfo updateBankRollLog(BankRollLogInfo bankrolllogInfo) throws IOException {

        if (bankrolllogInfo.getLogId() >= 1)
            return bankRollLogRepository.save(bankrolllogInfo);

        return bankrolllogInfo;

    }


    /**
     * 删除一条流水日志记录数据
     *
     * @param logId 流水日志记录模型
     **/
    @Override
    @Transactional
    public void deleteBankRollLogByLogId(int logId) throws IOException {

        bankRollLogRepository.deleteById(logId);
    }

    /**
     * 批量删除一批流水日志记录数据
     **/
    public void deleteBankRollLogByLogIdList(String logIdlist) throws IOException {


    }

    /**
     * 获得流水日志记录一条记录
     *
     * @param logId iogid
     * @return 返回一条BankRollLogInfo
     **/
    @Override
    @Transactional
    public BankRollLogInfo getBankRollLogByLogId(int logId) throws IOException {
        return bankRollLogRepository.findById(logId).get();
    }


    /**
     * 获得流水日志记录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BankRollLogInfo
     **/
    @Override
    @Transactional
    public List<BankRollLogInfo> getBankRollLogList(Specification<BankRollLogInfo> condition, Sort sort) throws IOException {

        return bankRollLogRepository.findAll(condition, sort);

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
    @Override
    @Transactional
    public Page<BankRollLogInfo> getBankRollLogList(Integer pageSize, Integer pageNumber, Specification<BankRollLogInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "logId");

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return bankRollLogRepository.findAll(condition, pageable);


    }


    //endregion


}



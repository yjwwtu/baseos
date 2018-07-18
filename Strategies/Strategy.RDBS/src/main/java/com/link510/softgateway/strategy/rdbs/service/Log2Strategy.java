package com.link510.softgateway.strategy.rdbs.service;

import com.link510.softgateway.core.data.rdbs.ILog2Strategy;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.CreditLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.LoginFailLogRepository;
import com.link510.softgateway.core.domain.authors.AuthorLogInfo;
import com.link510.softgateway.core.domain.users.CreditLogInfo;
import com.link510.softgateway.core.domain.users.LoginFailLogInfo;
import com.link510.softgateway.core.data.rdbs.ILog2Strategy;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.CreditLogRepository;
import com.link510.softgateway.core.data.rdbs.repository.users.LoginFailLogRepository;
import com.link510.softgateway.core.domain.authors.AuthorLogInfo;
import com.link510.softgateway.core.domain.users.CreditLogInfo;
import com.link510.softgateway.core.domain.users.LoginFailLogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Component(value = "Log2Strategy")
public class Log2Strategy implements ILog2Strategy {

    @Autowired
    com.link510.softgateway.core.data.rdbs.repository.authors.AuthorLogRepository AuthorLogRepository;

    //region 管理员日志

    /**
     * 获得管理员日志数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getAuthorLogCount(Specification<AuthorLogInfo> condition) throws IOException {

        return AuthorLogRepository.count();
    }


    /**
     * 创建一条管理员日志数据
     *
     * @param AuthorLogInfo 管理员日志模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public AuthorLogInfo createAuthorLog(AuthorLogInfo AuthorLogInfo) throws IOException {

        return AuthorLogRepository.save(AuthorLogInfo);
    }


    /**
     * 更新一条管理员日志数据
     *
     * @param AuthorLogInfo 管理员日志模型
     **/
    @Override
    @Transactional
    public AuthorLogInfo updateAuthorLog(AuthorLogInfo AuthorLogInfo) throws IOException {

        if (AuthorLogInfo.getAdminGid() >= 1)
            return AuthorLogRepository.save(AuthorLogInfo);

        return AuthorLogInfo;

    }


    /**
     * 删除一条管理员日志数据
     *
     * @param logid 管理员日志模型
     **/
    @Override
    @Transactional
    public void deleteAuthorLogByLogid(Integer logid) throws IOException {

        AuthorLogRepository.deleteById(logid);
    }

    /**
     * 批量删除一批管理员日志数据
     **/
    public void deleteAuthorLogByLogidList(String logidlist) throws IOException {


    }

    /**
     * 获得管理员日志一条记录
     *
     * @param logid logid
     * @return 返回一条AuthorLogInfo
     **/
    @Override
    @Transactional
    public AuthorLogInfo getAuthorLogByLogid(Integer logid) throws IOException {
        return AuthorLogRepository.findById(logid).get();
    }


    /**
     * 获得管理员日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorLogInfo
     **/
    @Override
    @Transactional
    public List<AuthorLogInfo> getAuthorLogList(Specification<AuthorLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "logId");

        return AuthorLogRepository.findAll(condition, sort);

    }


    /**
     * 获得管理员日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorLogInfo
     **/
    @Override
    @Transactional
    public Page<AuthorLogInfo> getAuthorLogList(Integer pageSize, Integer pageNumber, Specification<AuthorLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "logId");

if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return AuthorLogRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    CreditLogRepository creditLogRepository;

    //region 积分日志

    /**
     * 获得积分日志数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getCreditLogCount(Specification<CreditLogInfo> condition) throws IOException {

        return creditLogRepository.count();
    }


    /**
     * 创建一条积分日志数据
     *
     * @param creditlogInfo 积分日志模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public CreditLogInfo createCreditLog(CreditLogInfo creditlogInfo) throws IOException {

        return creditLogRepository.save(creditlogInfo);
    }


    /**
     * 更新一条积分日志数据
     *
     * @param creditLogInfo 积分日志模型
     **/
    @Override
    @Transactional
    public CreditLogInfo updateCreditLog(CreditLogInfo creditLogInfo) throws IOException {

        if (creditLogInfo.getLogId() >= 1)
            return creditLogRepository.save(creditLogInfo);

        return creditLogInfo;

    }


    /**
     * 删除一条积分日志数据
     *
     * @param logid 积分日志模型
     **/
    @Override
    @Transactional
    public void deleteCreditLogByLogid(Integer logid) throws IOException {

        creditLogRepository.deleteById(logid);
    }

    /**
     * 批量删除一批积分日志数据
     **/
    public void deleteCreditLogByLogidList(String logidlist) throws IOException {


    }

    /**
     * 获得积分日志一条记录
     *
     * @param logid logid
     * @return 返回一条CreditLogInfo
     **/
    @Override
    @Transactional
    public CreditLogInfo getCreditLogByLogid(Integer logid) throws IOException {
        return creditLogRepository.findById(logid).get();
    }


    /**
     * 获得积分日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回CreditLogInfo
     **/
    @Override
    @Transactional
    public List<CreditLogInfo> getCreditLogList(Specification<CreditLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "logId");

return creditLogRepository.findAll(condition, sort);

    }


    /**
     * 获得积分日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回CreditLogInfo
     **/
    @Override
    @Transactional
    public Page<CreditLogInfo> getCreditLogList(Integer pageSize, Integer pageNumber, Specification<CreditLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "logId");

if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return creditLogRepository.findAll(condition, pageable);


    }


    //endregion

    @Autowired
    LoginFailLogRepository loginFailLogRepository;


    //region 登录日志

    /**
     * 获得登录日志数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getLoginFailLogCount(Specification<LoginFailLogInfo> condition) throws IOException {

        return loginFailLogRepository.count();
    }


    /**
     * 创建一条登录日志数据
     *
     * @param loginfaillogInfo 登录日志模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public LoginFailLogInfo createLoginFailLog(LoginFailLogInfo loginfaillogInfo) throws IOException {

        return loginFailLogRepository.save(loginfaillogInfo);
    }


    /**
     * 更新一条登录日志数据
     *
     * @param loginFailLogInfo 登录日志模型
     **/
    @Override
    @Transactional
    public LoginFailLogInfo updateLoginFailLog(LoginFailLogInfo loginFailLogInfo) throws IOException {

        if (loginFailLogInfo.getId() >= 1)
            return loginFailLogRepository.save(loginFailLogInfo);

        return loginFailLogInfo;

    }


    /**
     * 删除一条登录日志数据
     *
     * @param id 登录日志模型
     **/
    @Override
    @Transactional
    public void deleteLoginFailLogById(Integer id) throws IOException {

        loginFailLogRepository.deleteById(id);
    }

    /**
     * 批量删除一批登录日志数据
     **/
    public void deleteLoginFailLogByIdList(String idlist) throws IOException {


    }

    /**
     * 获得登录日志一条记录
     *
     * @param id id
     * @return 返回一条LoginFailLogInfo
     **/
    @Override
    @Transactional
    public LoginFailLogInfo getLoginFailLogById(Integer id) throws IOException {
        return loginFailLogRepository.findById(id).get();
    }


    /**
     * 获得登录日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回LoginFailLogInfo
     **/
    @Override
    @Transactional
    public List<LoginFailLogInfo> getLoginFailLogList(Specification<LoginFailLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

return loginFailLogRepository.findAll(condition, sort);

    }


    /**
     * 获得登录日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回LoginFailLogInfo
     **/
    @Override
    @Transactional
    public Page<LoginFailLogInfo> getLoginFailLogList(Integer pageSize, Integer pageNumber, Specification<LoginFailLogInfo> condition, Sort sort) throws IOException {

		
        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return loginFailLogRepository.findAll(condition, pageable);


    }

    /**
     * 删除登录ip地址
     *
     * @param ip
     */
    public void deleteLoginFailLogByIP(Integer ip) throws IOException{
        loginFailLogRepository.deleteLoginFailLogByIP(ip);
    }


    //endregion
}

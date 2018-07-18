package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//用户-组关联表
@Service(value = "AuthorSessionsData")
public class AuthorSessions extends DataService {


    //region  用户-组关联表方法

    /**
     * 获得用户-组关联表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorSessionCount(Specification<AuthorSessionInfo> condition) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorSessionCount(condition);
    }

    /**
     * 创建一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     * @return 返回创建信息
     **/
    public AuthorSessionInfo createAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {
        return getCwmData().getIAuthorStrategy().createAuthorSession(authorsessionInfo);
    }

    /**
     * 更新一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     **/
    public AuthorSessionInfo updateAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {
        return getCwmData().getIAuthorStrategy().updateAuthorSession(authorsessionInfo);
    }

    /**
     * 删除一条用户-组关联表数据
     *
     * @param id 用户-组关联表模型
     **/
    public void deleteAuthorSessionById(Integer id) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorSessionById(id);
    }

    /**
     * 批量删除一批用户-组关联表数据
     **/
    public void deleteAuthorSessionByIdList(String idList) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorSessionByIdList(idList);
    }

    /**
     * 获取一条用户-组关联表数据
     *
     * @param id 用户-组关联表模型
     **/
    public AuthorSessionInfo getAuthorSessionById(Integer id) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorSessionById(id);
    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorSessionInfo
     **/
    public List<AuthorSessionInfo> getAuthorSessionList(Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorSessionList(condition, sort);
    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorSessionInfo
     **/
    public Page<AuthorSessionInfo> getAuthorSessionList(Integer pageSize, Integer pageNumber, Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorSessionList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}

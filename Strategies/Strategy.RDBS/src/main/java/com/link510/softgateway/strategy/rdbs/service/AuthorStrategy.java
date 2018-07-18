package com.link510.softgateway.strategy.rdbs.service;

import com.link510.softgateway.core.data.rdbs.IAuthorStrategy;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorActionRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorPermissionRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorRoleRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorSessionRepository;
import com.link510.softgateway.core.domain.authors.AuthorActionInfo;
import com.link510.softgateway.core.domain.authors.AuthorPermissionInfo;
import com.link510.softgateway.core.domain.authors.AuthorRoleInfo;
import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
import com.link510.softgateway.core.data.rdbs.IAuthorStrategy;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorActionRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorPermissionRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorRoleRepository;
import com.link510.softgateway.core.data.rdbs.repository.authors.AuthorSessionRepository;
import com.link510.softgateway.core.domain.authors.AuthorActionInfo;
import com.link510.softgateway.core.domain.authors.AuthorPermissionInfo;
import com.link510.softgateway.core.domain.authors.AuthorRoleInfo;
import com.link510.softgateway.core.domain.authors.AuthorSessionInfo;
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


@Component(value = "AdminStrategy")
public class AuthorStrategy implements IAuthorStrategy {

    @Autowired
    AuthorRoleRepository authorroleRepository;

    //region 用户分组表

    /**
     * 获得用户分组表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getAuthorRoleCount(Specification<AuthorRoleInfo> condition) throws IOException {

        return authorroleRepository.count();
    }


    /**
     * 创建一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public AuthorRoleInfo createAuthorRole(AuthorRoleInfo authorroleInfo) throws IOException {

        return authorroleRepository.save(authorroleInfo);
    }


    /**
     * 更新一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     **/
    @Override
    @Transactional
    public AuthorRoleInfo updateAuthorRole(AuthorRoleInfo authorroleInfo) throws IOException {

        if (authorroleInfo.getRoleId() >= 1)
            return authorroleRepository.save(authorroleInfo);

        return authorroleInfo;

    }


    /**
     * 删除一条用户分组表数据
     *
     * @param roleId 用户分组表模型
     **/
    @Override
    @Transactional
    public void deleteAuthorRoleByRoleId(Integer roleId) throws IOException {

        authorroleRepository.deleteById(roleId);
    }

    /**
     * 批量删除一批用户分组表数据
     **/
    public void deleteAuthorRoleByRoleIdList(String roleIdlist) throws IOException {


    }

    /**
     * 获得用户分组表一条记录
     *
     * @param roleId roleid
     * @return 返回一条AuthorRoleInfo
     **/
    @Override
    @Transactional
    public AuthorRoleInfo getAuthorRoleByRoleId(Integer roleId) throws IOException {
        return authorroleRepository.findById(roleId).get();
    }


    /**
     * 获得用户分组表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorRoleInfo
     **/
    @Override
    @Transactional
    public List<AuthorRoleInfo> getAuthorRoleList(Specification<AuthorRoleInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "roleId");

        return authorroleRepository.findAll(condition, sort);

    }


    /**
     * 获得用户分组表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorRoleInfo
     **/
    @Override
    @Transactional
    public Page<AuthorRoleInfo> getAuthorRoleList(Integer pageSize, Integer pageNumber, Specification<AuthorRoleInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "roleId");

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return authorroleRepository.findAll(condition, pageable);


    }


    /**
     * 获取用户的角色权限
     *
     * @param uid
     */
    @Override
    @Transactional
    public List<AuthorRoleInfo> getUserAuthorRoleList(Integer uid) throws IOException {

        return authorroleRepository.getUserAuthorRoleList(uid);
    }

    //endregion

    @Autowired
    AuthorSessionRepository authorsessionRepository;

    //region 用户-组关联表

    /**
     * 获得用户-组关联表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getAuthorSessionCount(Specification<AuthorSessionInfo> condition) throws IOException {

        return authorsessionRepository.count();
    }


    /**
     * 创建一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public AuthorSessionInfo createAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {

        return authorsessionRepository.save(authorsessionInfo);
    }


    /**
     * 更新一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     **/
    @Override
    @Transactional
    public AuthorSessionInfo updateAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {

        if (authorsessionInfo.getId() >= 1)
            return authorsessionRepository.save(authorsessionInfo);

        return authorsessionInfo;

    }


    /**
     * 删除一条用户-组关联表数据
     *
     * @param id 用户-组关联表模型
     **/
    @Override
    @Transactional
    public void deleteAuthorSessionById(Integer id) throws IOException {

        authorsessionRepository.deleteById(id);
    }

    /**
     * 批量删除一批用户-组关联表数据
     **/
    public void deleteAuthorSessionByIdList(String idlist) throws IOException {


    }

    /**
     * 获得用户-组关联表一条记录
     *
     * @param id id
     * @return 返回一条AuthorSessionInfo
     **/
    @Override
    @Transactional
    public AuthorSessionInfo getAuthorSessionById(Integer id) throws IOException {
        return authorsessionRepository.findById(id).get();
    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorSessionInfo
     **/
    @Override
    @Transactional
    public List<AuthorSessionInfo> getAuthorSessionList(Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

        return authorsessionRepository.findAll(condition, sort);

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
    @Override
    @Transactional
    public Page<AuthorSessionInfo> getAuthorSessionList(Integer pageSize, Integer pageNumber, Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return authorsessionRepository.findAll(condition, pageable);


    }


    //endregion

    @Autowired
    AuthorPermissionRepository authorpermissionRepository;

    //region 角色许可表

    /**
     * 获得角色许可表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getAuthorPermissionCount(Specification<AuthorPermissionInfo> condition) throws IOException {

        return authorpermissionRepository.count();
    }


    /**
     * 创建一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public AuthorPermissionInfo createAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {

        return authorpermissionRepository.save(authorpermissionInfo);
    }


    /**
     * 更新一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     **/
    @Override
    @Transactional
    public AuthorPermissionInfo updateAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {

        if (authorpermissionInfo.getId() >= 1)
            return authorpermissionRepository.save(authorpermissionInfo);

        return authorpermissionInfo;

    }


    /**
     * 删除一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    @Override
    @Transactional
    public void deleteAuthorPermissionById(Integer id) throws IOException {

        authorpermissionRepository.deleteById(id);
    }

    /**
     * 批量删除一批角色许可表数据
     **/
    public void deleteAuthorPermissionByIdList(String idlist) throws IOException {


    }

    /**
     * 获得角色许可表一条记录
     *
     * @param id id
     * @return 返回一条AuthorPermissionInfo
     **/
    @Override
    @Transactional
    public AuthorPermissionInfo getAuthorPermissionById(Integer id) throws IOException {
        return authorpermissionRepository.findById(id).get();
    }


    /**
     * 获得角色许可表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorPermissionInfo
     **/
    @Override
    @Transactional
    public List<AuthorPermissionInfo> getAuthorPermissionList(Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

        return authorpermissionRepository.findAll(condition, sort);

    }


    /**
     * 获得角色许可表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorPermissionInfo
     **/
    @Override
    @Transactional
    public Page<AuthorPermissionInfo> getAuthorPermissionList(Integer pageSize, Integer pageNumber, Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "id");

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return authorpermissionRepository.findAll(condition, pageable);


    }


    //endregion

    @Autowired
    AuthorActionRepository authorActionRepository;

    //region 动作管理

    /**
     * 获得动作管理数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getAuthorActionCount(Specification<AuthorActionInfo> condition) throws IOException {

        return authorActionRepository.count();
    }


    /**
     * 创建一条动作管理数据
     *
     * @param AuthorActionInfo 动作管理模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public AuthorActionInfo createAuthorAction(AuthorActionInfo AuthorActionInfo) throws IOException {

        return authorActionRepository.save(AuthorActionInfo);
    }


    /**
     * 更新一条动作管理数据
     *
     * @param actionInfo 动作管理模型
     **/
    @Override
    @Transactional
    public AuthorActionInfo updateAuthorAction(AuthorActionInfo actionInfo) throws IOException {

        if (actionInfo.getAid() >= 1)
            return authorActionRepository.save(actionInfo);

        return actionInfo;

    }


    /**
     * 删除一条动作管理数据
     *
     * @param aid 动作管理模型
     **/
    @Override
    @Transactional
    public void deleteAuthorActionByAid(Integer aid) throws IOException {

        authorActionRepository.deleteById(aid);
    }

    /**
     * 批量删除一批动作管理数据
     **/
    public void deleteAuthorActionByAidList(String aidlist) throws IOException {


    }

    /**
     * 获得动作管理一条记录
     *
     * @param aid aid
     * @return 返回一条AuthorActionInfo
     **/
    @Override
    @Transactional
    public AuthorActionInfo getAuthorActionByAid(Integer aid) throws IOException {
        return authorActionRepository.findById(aid).get();
    }


    /**
     * 获得动作管理数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorActionInfo
     **/
    @Override
    @Transactional
    public List<AuthorActionInfo> getAuthorActionList(Specification<AuthorActionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "aid");

        return authorActionRepository.findAll(condition, sort);

    }


    /**
     * 获得动作管理数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorActionInfo
     **/
    @Override
    @Transactional
    public Page<AuthorActionInfo> getAuthorActionList(Integer pageSize, Integer pageNumber, Specification<AuthorActionInfo> condition, Sort sort) throws IOException {


        if (sort == null)
            sort = new Sort(Sort.Direction.DESC, "aid");

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return authorActionRepository.findAll(condition, pageable);


    }

    /**
     * 获取角色的分组信息
     *
     * @param roleId 权限id
     * @return
     */
    @Override
    @Transactional
    public List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId) throws IOException {
        return authorActionRepository.getRoleAuthorActionList(roleId);
    }

    //endregion


}

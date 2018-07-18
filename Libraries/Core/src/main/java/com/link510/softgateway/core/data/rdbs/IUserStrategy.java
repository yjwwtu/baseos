/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.link510.softgateway.core.data.rdbs;

import com.link510.softgateway.core.domain.users.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/12/6.
 */
public interface IUserStrategy {

    //region 用户

    /**
     * 获得用户数量
     *
     * @param condition
     * @return 返回数量
     **/
    long getPartUserCount(Specification<PartUserInfo> condition) throws IOException;

    /**
     * 创建一条用户数据
     *
     * @param userInfo 用户模型
     * @return 返回创建信息
     **/
    PartUserInfo createPartUser(PartUserInfo userInfo) throws IOException;


    /**
     * 更新一条用户数据
     *
     * @param userInfo 用户模型
     **/
    PartUserInfo updatePartUser(PartUserInfo userInfo) throws IOException;

    /**
     * 删除一条用户数据
     *
     * @param uid 用户模型
     **/
    void deleteUserByUid(Integer uid) throws IOException;

    /**
     * 批量删除一批用户数据
     **/
    void deleteUserByUidList(String uidList) throws IOException;


    /**
     * 获得用户一条记录
     *
     * @param uid uid
     * @return 返回一条UserInfo
     **/
    PartUserInfo getPartUserByUid(Integer uid) throws IOException;

    /**
     * 通过手机号码获取用户
     *
     * @return
     */
    PartUserInfo getPartUserByMobile(String mobile) throws IOException;

    /**
     * 通过token获取用户信息
     *
     * @param openId
     * @return
     */
    PartUserInfo getPartUserByOpenId(String openId) throws IOException;

    /**
     * 通过unionId获取用户信息
     *
     * @param unionId
     * @return
     * @throws IOException
     */
    PartUserInfo getPartUserByUnionId(String unionId) throws IOException;

    /**
     * 通过用户名获取用户
     *
     * @return
     */
    PartUserInfo getPartUserByUserName(String userName) throws IOException;


    /**
     * 通过邮箱获取用户
     *
     * @return
     */
    PartUserInfo getPartUserByEmail(String email) throws IOException;


    /**
     * 获得用户数据列表
     *
     * @param specification 条件
     * @return 返回UserInfo
     **/
    List<PartUserInfo> getPartUserList(Specification<PartUserInfo> specification, Sort sort) throws IOException;


    /**
     * 获得用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @return 返回UserInfo
     **/
    Page<PartUserInfo> getPartUserList(Integer pageSize, Integer pageNumber, Specification<PartUserInfo> specification, Sort sort) throws IOException;


    /**
     * 判断邀请码是否存在
     *
     * @return
     */
    boolean isExitsInvitCode(String invitCode) throws IOException;


    /**
     * 更新用户组
     *
     * @param uid     用户uid
     * @param userRid 用户分组
     */
    void updateUserRankByUid(Integer uid, Integer userRid) throws IOException;

    /**
     * 更新手机
     *
     * @param uid
     * @param mobile
     */
    void updateUserMobile(Integer uid, String mobile) throws IOException;

    /**
     * 获取用户头像
     *
     * @param uid
     * @return
     */
    String getUserAvatar(Integer uid) throws IOException;

    //endregion 用户结束

    //region 用户详情

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getUserDetailCount(Specification<UserDetailInfo> condition) throws IOException;


    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     **/
    UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) throws IOException;


    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) throws IOException;

    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    void deleteUserDetailById(Integer id) throws IOException;

    /**
     * 批量删除一批用户详情数据
     **/
    void deleteUserDetailByIdList(String idList) throws IOException;


    /**
     * 获得用户详情一条记录
     *
     * @param id id
     * @return 返回一条UserDetailInfo
     **/
    UserDetailInfo getUserDetailById(Integer id) throws IOException;

    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) throws IOException;


    /**
     * 获得用户详情数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserDetailInfo
     **/
    Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) throws IOException;


    //endregion 用户详情结束

    //region 用户等级

    /**
     * 获得用户等级数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getUserRankCount(Specification<UserRankInfo> condition) throws IOException;


    /**
     * 创建一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     * @return 返回创建信息
     **/
    UserRankInfo createUserRank(UserRankInfo userRankInfo) throws IOException;


    /**
     * 更新一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     **/
    UserRankInfo updateUserRank(UserRankInfo userRankInfo) throws IOException;

    /**
     * 删除一条用户等级数据
     *
     * @param userRid 用户等级模型
     **/
    void deleteUserRankByUserRid(Integer userRid) throws IOException;

    /**
     * 批量删除一批用户等级数据
     **/
    void deleteUserRankByUserRidList(String userRidList) throws IOException;


    /**
     * 获得用户等级一条记录
     *
     * @param userRid userRid
     * @return 返回一条UserRankInfo
     **/
    UserRankInfo getUserRankByUserRid(Integer userRid) throws IOException;

    /**
     * 获得用户等级数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserRankInfo
     **/
    List<UserRankInfo> getUserRankList(Specification<UserRankInfo> condition, Sort sort) throws IOException;

    /**
     * 获取全部的分类列表
     *
     * @return
     */
    List<UserRankInfo> getUserRankAllList() throws IOException;

    /**
     * 获得用户等级数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserRankInfo
     **/
    Page<UserRankInfo> getUserRankList(Integer pageSize, Integer pageNumber, Specification<UserRankInfo> condition, Sort sort) throws IOException;


    /**
     * 获取全部用户组
     *
     * @return
     */
    List<UserRankInfo> getAllUserRankList() throws IOException;
    //endregion 用户等级结束

    //region 第三方登录

    /**
     * 获得第三方登录数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getOauthCount(Specification<OauthInfo> condition) throws IOException;


    /**
     * 创建一条第三方登录数据
     *
     * @param OauthInfo 第三方登录模型
     * @return 返回创建信息
     **/
    OauthInfo createOauth(OauthInfo OauthInfo) throws IOException;


    /**
     * 更新一条第三方登录数据
     *
     * @param OauthInfo 第三方登录模型
     **/
    OauthInfo updateOauth(OauthInfo OauthInfo) throws IOException;

    /**
     * 删除一条第三方登录数据
     *
     * @param id 第三方登录模型
     **/
    void deleteOauthById(Integer id) throws IOException;

    /**
     * 批量删除一批第三方登录数据
     **/
    void deleteOauthByIdList(String idList) throws IOException;


    /**
     * 获得第三方登录一条记录
     *
     * @param id id
     * @return 返回一条OauthInfo
     **/
    OauthInfo getOauthById(Integer id) throws IOException;

    /**
     * 通过 openid获取
     *
     * @param server
     * @param openId
     * @return
     */
    OauthInfo getOauthByOpenId(String server, String openId) throws IOException;


    /**
     * 通过unionId获取授权列表
     *
     * @param server
     * @param unionId
     * @return
     */
    List<OauthInfo> getOauthListByUnionId(String server, String unionId) throws IOException;


    /**
     * 通过openid和unionid获取用户授权信息
     *
     * @param server
     * @param openId
     * @param unionId
     * @return
     * @throws IOException
     */
    OauthInfo getOauthByOpenIdAndUnionId(String server, String openId, String unionId) throws IOException;


    /**
     * 通过uid获取Oauth列表
     *
     * @param server service
     * @param uid     用户uid
     * @return
     */
    List<OauthInfo> getOauthByUid(String server, Integer uid)  throws IOException;

    /**
     * 获得第三方登录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OauthInfo
     **/
    List<OauthInfo> getOauthList(Specification<OauthInfo> condition, Sort sort) throws IOException;


    /**
     * 获得第三方登录数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OauthInfo
     **/
    Page<OauthInfo> getOauthList(Integer pageSize, Integer pageNumber, Specification<OauthInfo> condition, Sort sort) throws IOException;


    //endregion 第三方登录结束

    //region 在线时间统计

    /**
     * 获得在线时间统计数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getOnlineTimeCount(Specification<OnlineTimeInfo> condition) throws IOException;


    /**
     * 创建一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     * @return 返回创建信息
     **/
    OnlineTimeInfo createOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException;


    /**
     * 更新一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     **/
    OnlineTimeInfo updateOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException;

    /**
     * 删除一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    void deleteOnlineTimeById(Integer id) throws IOException;

    /**
     * 批量删除一批在线时间统计数据
     **/
    void deleteOnlineTimeByIdList(String idList) throws IOException;


    /**
     * 获得在线时间统计一条记录
     *
     * @param id id
     * @return 返回一条OnlineTimeInfo
     **/
    OnlineTimeInfo getOnlineTimeById(Integer id) throws IOException;

    /**
     * 获得在线时间统计数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineTimeInfo
     **/
    List<OnlineTimeInfo> getOnlineTimeList(Specification<OnlineTimeInfo> condition, Sort sort) throws IOException;


    /**
     * 获得在线时间统计数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineTimeInfo
     **/
    Page<OnlineTimeInfo> getOnlineTimeList(Integer pageSize, Integer pageNumber, Specification<OnlineTimeInfo> condition, Sort sort) throws IOException;


    //endregion 在线时间统计结束

    //region 在线用户

    /**
     * 获得在线用户数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getOnlineUserCount(Specification<OnlineUserInfo> condition) throws IOException;


    /**
     * 创建一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     * @return 返回创建信息
     **/
    OnlineUserInfo createOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException;


    /**
     * 更新一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     **/
    OnlineUserInfo updateOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException;

    /**
     * 删除一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    void deleteOnlineUserByOlid(Integer olid) throws IOException;

    /**
     * 批量删除一批在线用户数据
     **/
    void deleteOnlineUserByOlidList(String olidList) throws IOException;


    /**
     * 获得在线用户一条记录
     *
     * @param olid olid
     * @return 返回一条OnlineUserInfo
     **/
    OnlineUserInfo getOnlineUserByOlid(Integer olid) throws IOException;

    /**
     * 获得在线用户数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineUserInfo
     **/
    List<OnlineUserInfo> getOnlineUserList(Specification<OnlineUserInfo> condition, Sort sort) throws IOException;


    /**
     * 获得在线用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineUserInfo
     **/
    Page<OnlineUserInfo> getOnlineUserList(Integer pageSize, Integer pageNumber, Specification<OnlineUserInfo> condition, Sort sort) throws IOException;



    //endregion 在线用户结束


}

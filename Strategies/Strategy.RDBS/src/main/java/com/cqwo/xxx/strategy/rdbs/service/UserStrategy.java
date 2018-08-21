package com.cqwo.xxx.strategy.rdbs.service;

import com.cqwo.xxx.core.data.rdbs.IUserStrategy;
import com.cqwo.xxx.core.data.rdbs.repository.users.*;
import com.cqwo.xxx.core.domain.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component(value = "UserStrategy")
public class UserStrategy extends RDBSService implements IUserStrategy {

    @Autowired
    UserRepository userRepository;


    //region 用户

    /**
     * 获得用户数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getPartUserCount(Specification<PartUserInfo> condition) throws IOException {
        return userRepository.count(condition);
    }


    /**
     * 创建一条用户数据
     *
     * @param userInfo 用户模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public PartUserInfo createPartUser(PartUserInfo userInfo) throws IOException {

        return userRepository.save(userInfo);
    }
    @Override
    public PartUserInfo updatePartUser(PartUserInfo userInfo) throws IOException {

        if (userInfo.getUid() >= 1) {
            userRepository.save(userInfo);
        }
        return userInfo;
    }
    @Override
    public void deleteUserByUid(Integer uid) throws IOException {

        userRepository.deleteById(uid);
    }
    @Override
    public void deleteUserByUidList(String uidList) throws IOException {

    }
    @Override
    public PartUserInfo getPartUserByUid(Integer uid) throws IOException {
        return userRepository.findById(uid).get();
    }
    @Override
    public PartUserInfo getPartUserByMobile(String mobile) throws IOException {

        List<PartUserInfo> userInfoList = userRepository.findByMobile(mobile);
        if (userInfoList.size() >= 1) {
            return userInfoList.get(0);
        }

        return null;
    }
    @Override
    public PartUserInfo getPartUserByUserName(String userName) throws IOException {

        List<PartUserInfo> userInfoList = userRepository.findByUserName(userName);
        if (userInfoList.size() >= 1) {
            return userInfoList.get(0);
        }

        return null;
    }
    @Override
    public PartUserInfo getPartUserByEmail(String email) throws IOException {

        List<PartUserInfo> userInfoList = userRepository.findByEmail(email);
        if (userInfoList.size() >= 1) {
            return userInfoList.get(0);
        }

        return null;
    }

    /**
     * 通过token获取用户信息
     *
     * @param openId
     * @return
     */
    @Override
    public PartUserInfo getPartUserByOpenId(String openId) throws IOException {

        List<PartUserInfo> userInfoList = userRepository.findByOpenId(openId);

        if (userInfoList.size() >= 1) {
            return userInfoList.get(0);
        }

        return null;
    }

    /**
     * 通过unionId获取用户信息
     *
     * @param unionId
     * @return
     * @throws IOException
     */
    @Override
    public PartUserInfo getPartUserByUnionId(String unionId) throws IOException {
        List<PartUserInfo> userInfoList = userRepository.findByUnionId(unionId);

        if (userInfoList.size() >= 1) {
            return userInfoList.get(0);
        }

        return null;
    }
    @Override
    public List<PartUserInfo> getPartUserList(Specification<PartUserInfo> specification, Sort sort) throws IOException {

        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "uid");
        }

        return userRepository.findAll(specification, sort);

    }
    @Override
    public Page<PartUserInfo> getPartUserList(Integer pageSize, Integer pageNumber, Specification<PartUserInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "uid");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return userRepository.findAll(condition, pageable);
    }

    @Override
    public boolean isExitsInvitCode(String invitCode) throws IOException {
        return userRepository.existsByInvitCode(invitCode);
    }

    /**
     * 更新用户组
     *
     * @param uid     用户uid
     * @param userRid 用户分组
     */
    @Override
    public void updateUserRankByUid(Integer uid, Integer userRid) throws IOException {
        userRepository.updateUserRankByUid(uid, userRid);
    }

    /**
     * 更新手机
     *
     * @param uid
     * @param mobile
     */
    @Override
    public void updateUserMobile(Integer uid, String mobile) throws IOException {
        userRepository.updateUserMobileByUid(uid, mobile);
    }

    /**
     * 获取用户头像
     *
     * @param uid
     * @return
     */
    @Override
    public String getUserAvatar(Integer uid) throws IOException {
        return userRepository.getUserAvatar(uid);
    }
    //endregion


    @Autowired
    UserDetailRepository userDetailRepository;

    //region 用户详情

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getUserDetailCount(Specification<UserDetailInfo> condition) throws IOException {

        return userDetailRepository.count();
    }


    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) throws IOException {

        return userDetailRepository.save(userdetailInfo);
    }


    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    @Override
    public UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) throws IOException {

        if (userdetailInfo.getId() >= 1) {
            return userDetailRepository.save(userdetailInfo);
        }

        return userdetailInfo;

    }


    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    @Override
    public void deleteUserDetailById(Integer id) throws IOException {

        userDetailRepository.deleteById(id);
    }

    /**
     * 批量删除一批用户详情数据
     **/
    @Override
    public void deleteUserDetailByIdList(String idlist) throws IOException {


    }

    /**
     * 获得用户详情一条记录
     *
     * @param id id
     * @return 返回一条UserDetailInfo
     **/
    @Override
    public UserDetailInfo getUserDetailById(Integer id) throws IOException {
        return userDetailRepository.findById(id).get();
    }


    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    @Override
    public List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return userDetailRepository.findAll(condition, sort);

    }


    /**
     * 获得用户详情数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserDetailInfo
     **/
    @Override
    public Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return userDetailRepository.findAll(condition, pageable);


    }


    //endregion

    @Autowired
    UserRankRepository userRankRepository;

    //region 用户等级

    /**
     * 获得用户等级数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getUserRankCount(Specification<UserRankInfo> condition) throws IOException {

        return userRankRepository.count();
    }


    /**
     * 创建一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public UserRankInfo createUserRank(UserRankInfo userRankInfo) throws IOException {

        return userRankRepository.save(userRankInfo);
    }


    /**
     * 更新一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     **/
    @Override
    public UserRankInfo updateUserRank(UserRankInfo userRankInfo) throws IOException {

        if (userRankInfo.getUserRid() >= 1) {
            return userRankRepository.save(userRankInfo);
        }

        return userRankInfo;

    }


    /**
     * 删除一条用户等级数据
     *
     * @param userRid 用户等级模型
     **/
    @Override
    public void deleteUserRankByUserRid(Integer userRid) throws IOException {

        userRankRepository.deleteById(userRid);
    }

    /**
     * 批量删除一批用户等级数据
     **/
    @Override
    public void deleteUserRankByUserRidList(String userRidList) throws IOException {


    }

    /**
     * 获得用户等级一条记录
     *
     * @param userRid userrid
     * @return 返回一条UserRankInfo
     **/
    @Override
    public UserRankInfo getUserRankByUserRid(Integer userRid) throws IOException {
        return userRankRepository.findById(userRid).get();
    }


    /**
     * 获得用户等级数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserRankInfo
     **/
    @Override
    public List<UserRankInfo> getUserRankList(Specification<UserRankInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "userRid");
        }

        return userRankRepository.findAll(condition, sort);

    }

    /**
     * 获取全部的分类列表
     *
     * @return
     */
    @Override
    public List<UserRankInfo> getUserRankAllList() throws IOException {
        return (List<UserRankInfo>) userRankRepository.findAll();
    }


    /**
     * 获得用户等级数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserRankInfo
     **/
    @Override
    public Page<UserRankInfo> getUserRankList(Integer pageSize, Integer pageNumber, Specification<UserRankInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "userRid");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return userRankRepository.findAll(condition, pageable);


    }


    /**
     * 获取全部用户组
     *
     * @return
     */
    @Override
    public List<UserRankInfo> getAllUserRankList() throws IOException {
        return (List<UserRankInfo>) userRankRepository.findAll();
    }


    //endregion

    @Autowired
    OauthRepository oauthRepository;

    //region 第三方登录

    /**
     * 获得第三方登录数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getOauthCount(Specification<OauthInfo> condition) throws IOException {

        return oauthRepository.count();
    }


    /**
     * 创建一条第三方登录数据
     *
     * @param oauthInfo 第三方登录模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public OauthInfo createOauth(OauthInfo oauthInfo) throws IOException {

        return oauthRepository.save(oauthInfo);
    }


    /**
     * 更新一条第三方登录数据
     *
     * @param oauthInfo 第三方登录模型
     **/
    @Override
    public OauthInfo updateOauth(OauthInfo oauthInfo) throws IOException {

        if (oauthInfo.getId() >= 1) {
            return oauthRepository.save(oauthInfo);
        }

        return oauthInfo;

    }


    /**
     * 删除一条第三方登录数据
     *
     * @param id 第三方登录模型
     **/
    @Override
    public void deleteOauthById(Integer id) throws IOException {

        oauthRepository.deleteById(id);
    }

    /**
     * 批量删除一批第三方登录数据
     **/
    @Override
    public void deleteOauthByIdList(String idlist) throws IOException {


    }

    /**
     * 获得第三方登录一条记录
     *
     * @param id id
     * @return 返回一条OauthInfo
     **/
    @Override
    public OauthInfo getOauthById(Integer id) throws IOException {
        return oauthRepository.findById(id).get();
    }

    /**
     * 通过 openid获取
     *
     * @param server
     * @param openId
     * @return
     */
    @Override
    public OauthInfo getOauthByOpenId(String server, String openId) {

        List<OauthInfo> oauthInfoList = oauthRepository.findByServerAndOpenId(server, openId);

        if (oauthInfoList.size() >= 1) {
            return oauthInfoList.get(0);
        }
        ;

        return null;

    }


    /**
     * 通过unionId获取授权列表
     *
     * @param server
     * @param unionId
     * @return
     */
    @Override
    public List<OauthInfo> getOauthListByUnionId(String server, String unionId) {
        return oauthRepository.findByServerAndUnionId(server, unionId);
    }

    /**
     * 通过openid和联合id获取
     *
     * @param server
     * @param openId
     * @param unionId
     * @return
     */
    @Override
    public OauthInfo getOauthByOpenIdAndUnionId(String server, String openId, String unionId) throws IOException {

        List<OauthInfo> oauthInfoList = getOauthListByUnionId(server, unionId);

        if (oauthInfoList.size() <= 0) {
            return null;
        }

        Integer uid = -1;

        for (OauthInfo info : oauthInfoList) {
            if (info.getOpenId().equals(openId)) {
                return info;
            }

            uid = info.getUid();
        }

        OauthInfo oauthInfo = new OauthInfo(uid, openId, unionId, server);

        return createOauth(oauthInfo);


    }

    /**
     * 通过uid获取Oauth列表
     *
     * @param server service
     * @param uid    用户uid
     * @return
     */
    @Override
    public List<OauthInfo> getOauthByUid(String server, Integer uid) throws IOException {

        return oauthRepository.findByServerAndUid(server, uid);

    }

    /**
     * 获得第三方登录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OauthInfo
     **/
    @Override
    public List<OauthInfo> getOauthList(Specification<OauthInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return oauthRepository.findAll(condition, sort);

    }


    /**
     * 获得第三方登录数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OauthInfo
     **/
    @Override
    public Page<OauthInfo> getOauthList(Integer pageSize, Integer pageNumber, Specification<OauthInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return oauthRepository.findAll(condition, pageable);


    }


    //endregion

    @Autowired
    OnlineTimeRepository onlineTimeRepository;

    //region 在线时间统计

    /**
     * 获得在线时间统计数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getOnlineTimeCount(Specification<OnlineTimeInfo> condition) throws IOException {

        return onlineTimeRepository.count();
    }


    /**
     * 创建一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public OnlineTimeInfo createOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {

        return onlineTimeRepository.save(onlinetimeInfo);
    }


    /**
     * 更新一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     **/
    @Override
    public OnlineTimeInfo updateOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {

        if (onlinetimeInfo.getId() >= 1) {
            return onlineTimeRepository.save(onlinetimeInfo);
        }

        return onlinetimeInfo;

    }


    /**
     * 删除一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    @Override
    public void deleteOnlineTimeById(Integer id) throws IOException {

        onlineTimeRepository.deleteById(id);
    }

    /**
     * 批量删除一批在线时间统计数据
     **/
    @Override
    public void deleteOnlineTimeByIdList(String idlist) throws IOException {


    }

    /**
     * 获得在线时间统计一条记录
     *
     * @param id id
     * @return 返回一条OnlineTimeInfo
     **/
    @Override
    public OnlineTimeInfo getOnlineTimeById(Integer id) throws IOException {
        return onlineTimeRepository.findById(id).get();
    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineTimeInfo
     **/
    @Override
    public List<OnlineTimeInfo> getOnlineTimeList(Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return onlineTimeRepository.findAll(condition, sort);

    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineTimeInfo
     **/
    @Override
    public Page<OnlineTimeInfo> getOnlineTimeList(Integer pageSize, Integer pageNumber, Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return onlineTimeRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    OnlineUserRepository onlineUserRepository;


    //region 在线用户

    /**
     * 获得在线用户数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getOnlineUserCount(Specification<OnlineUserInfo> condition) throws IOException {

        return onlineUserRepository.count();
    }


    /**
     * 创建一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public OnlineUserInfo createOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {

        return onlineUserRepository.save(onlineuserInfo);
    }


    /**
     * 更新一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     **/
    @Override
    public OnlineUserInfo updateOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {

        if (onlineuserInfo.getOlId() >= 1) {
            return onlineUserRepository.save(onlineuserInfo);
        }

        return onlineuserInfo;

    }


    /**
     * 删除一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    @Override
    public void deleteOnlineUserByOlid(Integer olid) throws IOException {

        onlineUserRepository.deleteById(olid);
    }

    /**
     * 批量删除一批在线用户数据
     **/
    @Override
    public void deleteOnlineUserByOlidList(String olidlist) throws IOException {


    }

    /**
     * 获得在线用户一条记录
     *
     * @param olid olid
     * @return 返回一条OnlineUserInfo
     **/
    @Override
    public OnlineUserInfo getOnlineUserByOlid(Integer olid) throws IOException {
        return onlineUserRepository.findById(olid).get();
    }


    /**
     * 获得在线用户数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineUserInfo
     **/
    @Override
    public List<OnlineUserInfo> getOnlineUserList(Specification<OnlineUserInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "olId");
        }

        return onlineUserRepository.findAll(condition, sort);

    }


    /**
     * 获得在线用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineUserInfo
     **/
    @Override
    public Page<OnlineUserInfo> getOnlineUserList(Integer pageSize, Integer pageNumber, Specification<OnlineUserInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "olId");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return onlineUserRepository.findAll(condition, pageable);


    }


    //endregion

}

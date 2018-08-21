package com.cqwo.xxx.core.data.rdbs.repository.users;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends BaseRepository<PartUserInfo, Integer> {


    /**
     * 通过手机号码查找用户信息
     *
     * @param mobile
     * @return
     */
    List<PartUserInfo> findByMobile(String mobile);


    /**
     * 通过用户名找用户信息
     *
     * @param userName
     * @return
     */
    List<PartUserInfo> findByUserName(String userName);


    /**
     * 通过邮箱查找用户信息
     *
     * @param email
     * @return
     */
    List<PartUserInfo> findByEmail(String email);


    /**
     * 通过token获取用户信息
     *
     * @param openId
     * @return
     */
    @Query("SELECT user FROM PartUserInfo user where exists (SELECT 1 FROM OauthInfo oauth where oauth.uid = user.uid and oauth.openId = ?1)")
    List<PartUserInfo> findByOpenId(String openId);



    /**
     * 通过token获取用户信息
     *
     * @param unionId
     * @return
     */
    @Query("SELECT user FROM PartUserInfo user where exists (SELECT 1 FROM OauthInfo oauth where oauth.uid = user.uid and oauth.unionId = ?1)")
    List<PartUserInfo> findByUnionId(String unionId);

    /**
     * 判断验证码是否存在
     *
     * @param invitCode
     * @return
     */
    boolean existsByInvitCode(String invitCode);

    /**
     * 更新用户分组
     *
     * @param uid
     * @param userRid
     */
    @Query("update PartUserInfo info set info.userRid = ?2 where info.uid = ?1")
    @Modifying
    @Transactional
    int updateUserRankByUid(Integer uid, Integer userRid);

    /**
     * 查询用户头像
     *
     * @param uid
     * @return
     */
    @Query("select info.avatar  from PartUserInfo info where uid = ?1")
    String getUserAvatar(Integer uid);


    /**
     * 更新用户手机号码
     *
     * @param uid
     * @param mobile
     */
    @Modifying
    @Query("update PartUserInfo info set info.mobile = ?2,info.verifyMobile=1 where info.uid=?1")
    @Transactional
    int updateUserMobileByUid(Integer uid, String mobile);


    /**
     * 更新用户余额
     *
     * @param uid   用户uid
     * @param money 更新的金额
     */
    @Transactional
    @Modifying
    @Query("update PartUserInfo info set info.money = info.money + ?2 where info.uid = ?1")
    int updateUserMoneyByUid(Integer uid, double money);
}

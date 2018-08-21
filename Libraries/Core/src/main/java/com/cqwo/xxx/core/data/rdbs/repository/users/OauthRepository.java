package com.cqwo.xxx.core.data.rdbs.repository.users;

import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.data.rdbs.repository.BaseRepository;
import com.cqwo.xxx.core.domain.users.OauthInfo;

import java.util.List;

public interface OauthRepository extends BaseRepository<OauthInfo, Integer> {

    /**
     * 获取openid的用户信息
     *
     * @param server
     * @param openId
     * @return
     */
    List<OauthInfo> findByServerAndOpenId(String server, String openId);

    /**
     * 通过unionId获取授权列表
     *
     * @param server
     * @param unionId
     * @return
     */
    List<OauthInfo> findByServerAndUnionId(String server, String unionId);

    /**
     * 通过uid获取Oauth列表
     *
     * @param server service
     * @param uid    用户uid
     * @return
     */
    List<OauthInfo> findByServerAndUid(String server, Integer uid);
}

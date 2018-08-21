package com.cqwo.xxx.data;

import com.cqwo.xxx.core.domain.users.OauthInfo;
import com.cqwo.xxx.core.domain.users.OauthInfo;
import com.cqwo.xxx.core.domain.users.OauthInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//第三方登录
@Service(value = "OauthsData")
public class Oauths extends DataService {


    //region  第三方登录方法

    /**
     * 获得第三方登录数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getOauthCount(Specification<OauthInfo> condition) throws IOException {
        return getCwmData().getIUserStrategy().getOauthCount(condition);
    }

    /**
     * 创建一条第三方登录数据
     *
     * @param oauthInfo 第三方登录模型
     * @return 返回创建信息
     **/
    public OauthInfo createOauth(OauthInfo oauthInfo) throws IOException {
        return getCwmData().getIUserStrategy().createOauth(oauthInfo);
    }

    /**
     * 更新一条第三方登录数据
     *
     * @param oauthInfo 第三方登录模型
     **/
    public OauthInfo updateOauth(OauthInfo oauthInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateOauth(oauthInfo);
    }

    /**
     * 删除一条第三方登录数据
     *
     * @param id 第三方登录模型
     **/
    public void deleteOauthById(Integer id) throws IOException {
        getCwmData().getIUserStrategy().deleteOauthById(id);
    }

    /**
     * 批量删除一批第三方登录数据
     **/
    public void deleteOauthByIdList(String idList) throws IOException {
        getCwmData().getIUserStrategy().deleteOauthByIdList(idList);
    }

    /**
     * 获取一条第三方登录数据
     *
     * @param id 第三方登录模型
     **/
    public OauthInfo getOauthById(Integer id) throws IOException {
        return getCwmData().getIUserStrategy().getOauthById(id);
    }


    /**
     * 通过 openid获取
     *
     * @param server
     * @param openId
     * @return
     */
    public OauthInfo getOauthByOpenId(String server, String openId) throws IOException {
        return getCwmData().getIUserStrategy().getOauthByOpenId(server, openId);
    }

    /**
     * 通过unionId获取授权列表
     *
     * @param server
     * @param unionId
     * @return
     */
    public List<OauthInfo> getOauthListByUnionId(String server, String unionId) throws IOException {
        return getCwmData().getIUserStrategy().getOauthListByUnionId(server, unionId);
    }


    /**
     * 通过openid和unionid获取用户授权信息
     *
     * @param server
     * @param openId
     * @param unionId
     * @return
     * @throws IOException
     */
    public OauthInfo getOauthByOpenIdAndUnionId(String server, String openId, String unionId) throws IOException {
        return getCwmData().getIUserStrategy().getOauthByOpenIdAndUnionId(server, openId, unionId);
    }


    /**
     * 通过uid获取Oauth列表
     *
     * @param server service
     * @param uid     用户uid
     * @return
     */
    public List<OauthInfo> getOauthByUid(String server, Integer uid)  throws IOException{
        return getCwmData().getIUserStrategy().getOauthByUid(server, uid);
    }


    /**
     * 获得第三方登录数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OauthInfo
     **/
    public List<OauthInfo> getOauthList(Specification<OauthInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOauthList(condition, sort);
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
    public Page<OauthInfo> getOauthList(Integer pageSize, Integer pageNumber, Specification<OauthInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOauthList(pageSize, pageNumber, condition, sort);
    }



    //endregion

}

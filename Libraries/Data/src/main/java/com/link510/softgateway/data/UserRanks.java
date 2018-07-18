package com.link510.softgateway.data;

import com.link510.softgateway.core.domain.users.UserRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//用户等级
@Service(value = "UserRanksData")
public class UserRanks extends DataService {


    //region  用户等级方法

    /**
     * 获得用户等级数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getUserRankCount(Specification<UserRankInfo> condition) throws IOException {
        return getCwmData().getIUserStrategy().getUserRankCount(condition);
    }

    /**
     * 创建一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     * @return 返回创建信息
     **/
    public UserRankInfo createUserRank(UserRankInfo userRankInfo) throws IOException {
        return getCwmData().getIUserStrategy().createUserRank(userRankInfo);
    }

    /**
     * 更新一条用户等级数据
     *
     * @param userRankInfo 用户等级模型
     **/
    public UserRankInfo updateUserRank(UserRankInfo userRankInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateUserRank(userRankInfo);
    }

    /**
     * 删除一条用户等级数据
     *
     * @param userRid 用户等级模型
     **/
    public void deleteUserRankByUserRid(Integer userRid) throws IOException {
        getCwmData().getIUserStrategy().deleteUserRankByUserRid(userRid);
    }

    /**
     * 批量删除一批用户等级数据
     **/
    public void deleteUserRankByUserRidList(String userRidList) throws IOException {
        getCwmData().getIUserStrategy().deleteUserRankByUserRidList(userRidList);
    }

    /**
     * 获取一条用户等级数据
     *
     * @param userRid 用户等级模型
     **/
    public UserRankInfo getUserRankByUserRid(Integer userRid) throws IOException {
        return getCwmData().getIUserStrategy().getUserRankByUserRid(userRid);
    }


    /**
     * 获得用户等级数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserRankInfo
     **/
    public List<UserRankInfo> getUserRankList(Specification<UserRankInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getUserRankList(condition, sort);
    }

    /**
     * 获取全部的分类列表
     * @return
     */
    public List<UserRankInfo> getUserRankAllList() throws IOException{
        return getCwmData().getIUserStrategy().getUserRankAllList();
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
    public Page<UserRankInfo> getUserRankList(Integer pageSize, Integer pageNumber, Specification<UserRankInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getUserRankList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获取全部用户组
     *
     * @return
     */
    public List<UserRankInfo> getAllUserRankList() throws IOException {
        return getCwmData().getIUserStrategy().getAllUserRankList();
    }


    //endregion

}

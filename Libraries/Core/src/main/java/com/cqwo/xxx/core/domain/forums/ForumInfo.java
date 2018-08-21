package com.cqwo.xxx.core.domain.forums;

import com.cqwo.xxx.core.helper.DateHelper;

import javax.persistence.*;
import java.io.Serializable;

//论坛主表
@Entity
@Table(name = "w_forum")
public class ForumInfo implements Serializable {

    private static final long serialVersionUID = -7817085791993642978L;
    /**
     * 论坛Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumId = 0;

    /**
     * 分类Id
     **/
    @Column(name = "cateid", nullable = false)
    private Integer cateId = 0;

    /**
     * 分类名称
     */
    @Column(name = "catename", nullable = false)
    private String cateName = "";

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;

    /**
     * 昵称
     **/
    @Column(name = "nickname", nullable = false)
    private String nickName = "";

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false)
    private String title = "";

    /**
     * @用户
     **/
    @Column(name = "at", nullable = false)
    private String at = "";

    /**
     * 纬度
     **/
    @Column(name = "latitude", nullable = false)
    private double latitude = 0;

    /**
     * 经度
     **/
    @Column(name = "longitude", nullable = false)
    private double longitude = 0;

    /**
     * 地址
     **/
    @Column(name = "address", nullable = false)
    private String address = "";


    /**
     * 缩略图
     **/
    @Column(name = "litpic", nullable = false)
    private String litpic = "";



    /**
     * 报事视频
     **/
    @Column(name = "mediaurl", nullable = false)
    private String mediaUrl = "";

    /**
     * 内容
     **/
    @Column(name = "body", nullable = false)
    private String body = "";

    /**
     * 是否显示
     **/
    @Column(name = "isshow", nullable = false)
    private Integer isShow = 0;

    /**
     * 是否置新
     **/
    @Column(name = "isnew", nullable = false)
    private Integer isNew = 0;

    /**
     * 置新过期时间
     **/
    @Column(name = "newexpiretime", nullable = false)
    private Integer newExpireTime = 0;

    /**
     * 是否置顶
     **/
    @Column(name = "ishot", nullable = false)
    private Integer isHot = 0;

    /**
     * 置热过期时间
     **/
    @Column(name = "hotexpiretime", nullable = false)
    private Integer hotExpireTime = 0;

    /**
     * 是否置顶
     **/
    @Column(name = "istop", nullable = false)
    private Integer isTop = 0;

    /**
     * 置顶过期时间
     **/
    @Column(name = "topexpiretime", nullable = false)
    private Integer topExpireTime = 0;

    /**
     * 点击量
     **/
    @Column(name = "click", nullable = false)
    private Integer click = 0;

    /**
     * 点赞数
     **/
    @Column(name = "praisecount", nullable = false)
    private Integer praiseCount = 0;


    /**
     * 回贴数统计
     */
    @Column(name = "postcount",nullable = false)
    private Integer postCount = 0;

    /**
     * 添加时间
     **/
    @Column(name = "addtime", nullable = false)
    private Integer addTime = DateHelper.getUnixTimeStamp();

    /**
     * 更新时间
     **/
    @Column(name = "updatetime", nullable = false)
    private Integer updateTime = DateHelper.getUnixTimeStamp();

    /**
     * 是否删除
     **/
    @Column(name = "isdelete", nullable = false)
    private Integer isDelete = 0;

    public ForumInfo() {
    }


    public ForumInfo(Integer cateId, String cateName, Integer uid, String nickName, String title, String at, double latitude, double longitude, String address, String litpic, String mediaUrl, String body, Integer isShow, Integer isNew, Integer newExpireTime, Integer isHot, Integer hotExpireTime, Integer isTop, Integer topExpireTime, Integer click, Integer praiseCount, Integer postCount, Integer addTime, Integer updateTime, Integer isDelete) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.uid = uid;
        this.nickName = nickName;
        this.title = title;
        this.at = at;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.litpic = litpic;
        this.mediaUrl = mediaUrl;
        this.body = body;
        this.isShow = isShow;
        this.isNew = isNew;
        this.newExpireTime = newExpireTime;
        this.isHot = isHot;
        this.hotExpireTime = hotExpireTime;
        this.isTop = isTop;
        this.topExpireTime = topExpireTime;
        this.click = click;
        this.praiseCount = praiseCount;
        this.postCount = postCount;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLitpic() {
        return litpic;
    }

    public void setLitpic(String litpic) {
        this.litpic = litpic;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getNewExpireTime() {
        return newExpireTime;
    }

    public void setNewExpireTime(Integer newExpireTime) {
        this.newExpireTime = newExpireTime;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getHotExpireTime() {
        return hotExpireTime;
    }

    public void setHotExpireTime(Integer hotExpireTime) {
        this.hotExpireTime = hotExpireTime;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getTopExpireTime() {
        return topExpireTime;
    }

    public void setTopExpireTime(Integer topExpireTime) {
        this.topExpireTime = topExpireTime;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ForumInfo{" +
                "forumId=" + forumId +
                ", cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", title='" + title + '\'' +
                ", at='" + at + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", litpic='" + litpic + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", body='" + body + '\'' +
                ", isShow=" + isShow +
                ", isNew=" + isNew +
                ", newExpireTime=" + newExpireTime +
                ", isHot=" + isHot +
                ", hotExpireTime=" + hotExpireTime +
                ", isTop=" + isTop +
                ", topExpireTime=" + topExpireTime +
                ", click=" + click +
                ", praiseCount=" + praiseCount +
                ", postCount=" + postCount +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
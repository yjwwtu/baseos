package com.cqwo.xxx.web.api.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


/**
 * 论坛添加模型
 */
public class ForumAddPostModel {

    /**
     * 报事栏目
     **/
    @Range(min = 1, message = "请选择正确的圈子")
    @NotNull(message = "请选择圈子")
    private Integer cateId = 0;




    /**
     * 详细内容
     */
    @Length(min = 2, max = 500, message = "圈子长度内容为2到500")
    @NotNull(message = "请认真填写内容")
    private String body = "";

    /**
     * 邀请谁关注
     */
    private String at = "";


    /**
     * 纬度
     **/
    @NotNull(message = "请输入正确的纬度")
    private double latitude = 0;

    /**
     * 经度
     **/
    @NotNull(message = "请输入正确的经度")
    private double longitude = 0;

    /**
     * 地址
     **/
    @NotNull(message = "请输入正确的地址")
    @Length(min = 2, message = "请输入正确的地址")
    private String address = "";


    /**
     * 报事视频
     **/
    private String mediaUrl = "";

    /**
     * 附件列表
     */
    private List<String> imgUrlList = new ArrayList<>();

    public ForumAddPostModel() {
    }


    public ForumAddPostModel(@Range(min = 1, message = "请选择正确的圈子") @NotNull(message = "请选择圈子") Integer cateId, @Length(min = 2, max = 500, message = "圈子长度内容为2到500") @NotNull(message = "请认真填写内容") String body, String at, @NotNull(message = "请输入正确的纬度") double latitude, @NotNull(message = "请输入正确的经度") double longitude, @NotNull(message = "请输入正确的地址") @Length(min = 2, message = "请输入正确的地址") String address, String mediaUrl, List<String> imgUrlList) {
        this.cateId = cateId;
        this.body = body;
        this.at = at;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.mediaUrl = mediaUrl;
        this.imgUrlList = imgUrlList;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public List<String> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<String> imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    @Override
    public String toString() {
        return "ForumAddPostModel{" +
                "cateId=" + cateId +
                ", body='" + body + '\'' +
                ", at='" + at + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", imgUrlList=" + imgUrlList +
                '}';
    }
}

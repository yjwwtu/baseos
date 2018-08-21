package com.cqwo.xxx.web.admin.model;

import com.cqwo.xxx.core.domain.base.RegionInfo;
import com.cqwo.xxx.core.model.SelectListItem;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class UserEditModel {

    /**
     * Uid
     */
    @NotNull(message = "用户名不能为空")
    @Min(value = 1, message = "Uid必须大于1")
    private int uid = -1;


    /**
     * 用户名
     **/
    @NotNull(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度必须在5-20之间")
    private String userName = "";
    /**
     * 邮箱
     **/
    @NotNull(message = "邮箱不能为空")
    @Length(min = 5, max = 20, message = "邮箱长度必须在5-20之间")
    @Email(message = "请输入正确的邮箱")
    private String email = "";
    /**
     * 手机
     **/
    @NotNull(message = "手机不能为空")
    @Length(min = 5, max = 20, message = "手机长度必须不正确")
    @Pattern(regexp = "^((13[0-9])|(14[57])|(15[012356789])|(17[678])|(18[0123456789]))\\d{8}$", message = "请输入正确的手机号码")
    private String mobile = "";

    /**
     * 密码
     **/
    @Length(min = 0, max = 20, message = "密码长度必须在0-20之间")
    private String password = "";
    /**
     * 用户等级
     **/
    @NotNull(message = "用户等级不能为空")
    @Range(min = 1, message = "请选择正确的用户等级")
    private int userRid = 0;
    /**
     * 昵称
     **/
    @NotNull(message = "用户昵称不能为空")
    private String nickName = "";
    /**
     * 真实姓名
     **/
    @NotNull(message = "真实姓名不能为空")
    private String realName = "";

    /**
     * 所在区域
     **/
    private int regionId = 0;
    /**
     * 地址
     **/
    @NotNull(message = "地址不能为空")
    private String address = "";

    /**
     * 用户详情
     */
    @NotNull(message = "用户详情不能为空")
    private String bio = "";


    /**
     * 用户列表
     */
    private List<SelectListItem> userRankItemList;

    /**
     * 区域模型
     */
    private RegionInfo regionInfo;


    public UserEditModel() {
    }

    public UserEditModel(@NotNull(message = "用户名不能为空") @Min(value = 1, message = "Uid必须大于1") int uid, @NotNull(message = "用户名不能为空") @Length(min = 5, max = 20, message = "用户名长度必须在5-20之间") String userName, @NotNull(message = "邮箱不能为空") @Length(min = 5, max = 20, message = "邮箱长度必须在5-20之间") @Email(message = "请输入正确的邮箱") String email, @NotNull(message = "手机不能为空") @Length(min = 5, max = 20, message = "手机长度必须不正确") @Pattern(regexp = "^((13[0-9])|(14[57])|(15[012356789])|(17[678])|(18[0123456789]))\\d{8}$", message = "请输入正确的手机号码") String mobile, @Length(min = 0, max = 20, message = "密码长度必须在0-20之间") String password, int userRid, @NotNull(message = "用户昵称不能为空") String nickName, String realName, int regionId, String address, String bio, List<SelectListItem> userRankItemList, RegionInfo regionInfo) {
        this.uid = uid;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.userRid = userRid;
        this.nickName = nickName;
        this.realName = realName;
        this.regionId = regionId;
        this.address = address;
        this.bio = bio;
        this.userRankItemList = userRankItemList;
        this.regionInfo = regionInfo;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid=uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile=mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public int getUserRid() {
        return userRid;
    }

    public void setUserRid(int userRid) {
        this.userRid=userRid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName=nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName=realName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId=regionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<SelectListItem> getUserRankItemList() {
        return userRankItemList;
    }

    public void setUserRankItemList(List<SelectListItem> userRankItemList) {
        this.userRankItemList=userRankItemList;
    }



    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo=regionInfo;
    }

    @Override
    public String toString() {
        return "UserEditModel{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", userRid=" + userRid +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", regionId=" + regionId +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", userRankItemList=" + userRankItemList +
                ", regionInfo=" + regionInfo +
                '}';
    }


}

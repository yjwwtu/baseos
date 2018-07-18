package com.link510.softgateway.web.framework.shiro;

import com.link510.softgateway.core.domain.authors.AuthorActionInfo;
import com.link510.softgateway.core.domain.authors.AuthorRoleInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.core.helper.TypeHelper;
import com.link510.softgateway.core.helper.ValidateHelper;
import com.link510.softgateway.services.*;
import com.link510.softgateway.web.framework.model.LoginType;
import com.link510.softgateway.web.framework.model.UserTokenPasswordToken;
import com.link510.softgateway.core.domain.authors.AuthorActionInfo;
import com.link510.softgateway.core.domain.authors.AuthorRoleInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.domain.users.UserRankInfo;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.core.helper.TypeHelper;
import com.link510.softgateway.core.helper.ValidateHelper;
import com.link510.softgateway.services.*;
import com.link510.softgateway.web.framework.model.LoginType;
import com.link510.softgateway.web.framework.model.UserTokenPasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cdyoue on 2016/10/21.
 */


public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Users users;


    @Autowired
    private Logs logs;


    @Autowired
    private LoginFailLogs loginFailLogs;

    @Autowired
    private UserRanks userRanks;

    @Autowired
    private Authors authors;

    @Override
    public String getName() {
        return "UserRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("doGetAuthorizationInfo+" + principals.toString());

        System.out.println(principals.getPrimaryPrincipal());


        Integer uid = TypeHelper.ObjectToInt(principals.getPrimaryPrincipal());

        //String shiroLoginUser = (String) principals.fromRealm(getName()).iterator().next();


        System.out.println("principals.getRealmNames():" + getName());
        System.out.println("account:" + uid);


        PartUserInfo userInfo = users.getPartUserByUid(uid);

//        //检测账号类型
//        if (ValidateHelper.isValidEmail(account)) {
//            userInfo = users.getPartUserByEmail(account);
//            logs.Write("邮箱登录");
//        } else if (ValidateHelper.isValidMobile(account)) {
//            userInfo = users.getPartUserByMobile(account);
//            logs.Write("手机登录");
//        } else {
//            userInfo = users.getPartUserByUserName(account);
//            logs.Write("账号登录");
//        }


        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();

        if (userInfo == null)
            return auth;

        List<AuthorRoleInfo> authorRoleList = authors.getUserAuthorRoleList(uid);

        //赋予管理员角色
        for (AuthorRoleInfo roleInfo : authorRoleList) {
            auth.addRole(roleInfo.getCode());
        }

        List<AuthorActionInfo> authorActionList = authors.getUserAuthorActionList(uid);

        for (AuthorActionInfo actionInfo : authorActionList) {
            System.out.println(actionInfo.toString());
            auth.addStringPermission(actionInfo.getAction());
        }

       // System.out.println(auth.getStringPermissions().toString());

        return auth;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //logger.info("doGetAuthenticationInfo +" + authenticationToken.toString());


        UserTokenPasswordToken token = (UserTokenPasswordToken) authenticationToken;

        if(token ==null){
            throw new UnknownAccountException("未找到用户信息");
        }


        PartUserInfo userInfo = null;
        System.out.println("我应在江湖悠悠,饮一壶浊酒..." + getName());
        System.out.println(authenticationToken.toString());

        if (token.getType() == LoginType.TokenLogin.getIndex()) {

            Integer uid = TypeHelper.StringToInt(token.getUsername());

//            if (StringHelper.IsNullOrWhiteSpace(accessToken))
//                throw new UnknownAccountException("未找到用户信息");


            userInfo = users.getPartUserByUid(uid);

            if (userInfo == null || userInfo.getUid() <= 0)
                throw new UnknownAccountException("未找到用户信息");


        } else {

            String account = token.getUsername();

            //检测账号类型
            if (ValidateHelper.isValidEmail(account)) {
                userInfo = users.getPartUserByEmail(account);
                logs.Write("邮箱登录");
            } else if (ValidateHelper.isValidMobile(account)) {
                userInfo = users.getPartUserByMobile(account);
                logs.Write("手机登录");
            } else {
                userInfo = users.getPartUserByUserName(account);
                logs.Write("账号登录");
            }


            //检测模型是否存在
            if (userInfo == null || userInfo.getUid() <= 0) {
                throw new UnknownAccountException("未找到用户信息");
            }


            System.out.println(userInfo.toString());

            String sourcePassword = Arrays.toString(token.getPassword());


            String password = Users.createUserPassword(sourcePassword, userInfo.getSalt());

            logger.error("password:" + password);
            logger.error("userInfo.getPassword():" + userInfo.getPassword());

            //检测密码是否正确
            if (!userInfo.getPassword().equals(password)) {
                loginFailLogs.addLoginFailTimes("127.0.0.1", DateHelper.getTimestamp());//增加登陆失败次数 要完善

                throw new IncorrectCredentialsException("用户账号名或密码错误..");


            }

        }


        if (userInfo.getLiftBanTime() >= DateHelper.getUnixTimeStamp())//达到解禁时间
        {
            throw new LockedAccountException("您的账号当前被锁定,不能访问");
        }

        UserRankInfo userRankInfo = userRanks.getUserRankByCredits(userInfo.getPayCredits());

        if (userRankInfo != null && userInfo.getUserRid() != userInfo.getUserRid()) {
            users.updateUserRankByUid(userInfo.getUid(), userRankInfo.getUserRid());
            userInfo.setUserRid(userRankInfo.getUserRid());
        }


        loginFailLogs.deleteLoginFailLogByIP("127.0.0.1");
        

        Session session = SecurityUtils.getSubject().getSession();


        session.setAttribute("userinfo", userInfo);


        System.out.println("处理数据,...sawq");

        return new SimpleAuthenticationInfo(userInfo.getUid(), token.getPassword(), getName());
    }
}


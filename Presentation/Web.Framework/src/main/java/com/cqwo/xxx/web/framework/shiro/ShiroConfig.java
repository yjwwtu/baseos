package com.cqwo.xxx.web.framework.shiro;


import com.cqwo.xxx.web.framework.filter.ApiAccessControlFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cqnews
 */
@Configuration
public class ShiroConfig {


    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);


    @Autowired
    SecurityManager securityManager;




//    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//
//        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//
//
//        chainDefinition.addPathDefinition("/api/author/**", "anon");
//
//
//        chainDefinition.addPathDefinition("/api/**", "anon");
//
//        // logged in users with the 'admin' role
//        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]"); //, roles[admin]
//
//        // logged in users with the 'document:read' permission
//        chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
//
//        chainDefinition.addPathDefinition("/static/**", "anon"); //匿名访问静态资源
//
//        chainDefinition.addPathDefinition("/components/**", "anon"); //匿名访问静态资源
//
//
//        chainDefinition.addPathDefinition("/tool/**", "anon"); //匿名访问静态资源
//
//        chainDefinition.addPathDefinition("/logout", "logout");
//
//        // all other paths require a logged in user
//        chainDefinition.addPathDefinition("/**", "anon");
//
//
//        chainDefinition.getFilterChainMap();
//
//        return chainDefinition;
//    }
//
    @Bean
    public AccessControlFilter myAccessControlFilter() {

        return new ApiAccessControlFilter();
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");


        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        filtersMap.put("apiAccessControlFilter", new ApiAccessControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/api/author/**", "anon");

        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/test", "anon");
        filterChainDefinitionMap.put("/test2", "anon");

        filterChainDefinitionMap.put("/api/index", "anon");
        filterChainDefinitionMap.put("/api/**/list", "anon");
        filterChainDefinitionMap.put("/api/tool/**", "anon");
        filterChainDefinitionMap.put("/api/**/catelist", "anon");


        filterChainDefinitionMap.put("/api/**", "apiAccessControlFilter");


//        // logged in users with the 'admin' role
//        filterChainDefinitionMap.put("/admin/**", "authc, roles[admin]"); //, roles[admin]

        // logged in users with the 'document:read' permission
        filterChainDefinitionMap.put("/docs/**", "authc, perms[document:read]");

        filterChainDefinitionMap.put("/static/**", "anon"); //匿名访问静态资源

        filterChainDefinitionMap.put("/hello", "anon"); //匿名访问静态资源

        filterChainDefinitionMap.put("/components/**", "anon"); //匿名访问静态资源


        filterChainDefinitionMap.put("/tool/**", "anon"); //匿名访问静态资源

        // all other paths require a logged in user
        filterChainDefinitionMap.put("/linkos/**", "anon");

        // all other paths require a logged in user
        filterChainDefinitionMap.put("/**", "authc");//authc


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }




    @Bean
    public Realm realm() {

        UserRealm userRealm = new UserRealm();
        userRealm.setCachingEnabled(true);

        return userRealm;

    }

//    @Bean
//    public Realm realm() {
//
//        APIRealm apiRealm = new APIRealm();
//        apiRealm.setCachingEnabled(true);
//
//        return apiRealm;
//    }

//    @Override
//    protected ShiroFilterFactoryBean shiroFilterFactoryBean() {
//        ShiroFilterFactoryBean factoryBean = super.shiroFilterFactoryBean();
////        Map<String, Filter> filterMap = new LinkedHashMap<>();
////        //添加自定义的Filter,这里我随便new了一个filter
////        filterMap.put("anyrole", new MyAccessControlFilter());
////        factoryBean.setFilters(filterMap);
//        return factoryBean;
//    }





    @Bean
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @ModelAttribute(name = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    /**
     * Shiro生命周期处理器 * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能 * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
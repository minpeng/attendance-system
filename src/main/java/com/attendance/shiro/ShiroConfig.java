package com.attendance.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pengm on 2018/2/23.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/common/unauthorized", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login/**", "anon");

        filterChainDefinitionMap.put("/attendance/**", "authc");
        filterChainDefinitionMap.put("/manager/**", "roles[2]");
        filterChainDefinitionMap.put("/user/**", "roles[3]");
        filterChainDefinitionMap.put("/admin/**", "roles[3]");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
       filterChainDefinitionMap.put("/login/logout", "logout");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login/login");
        //登录成功后要跳转的链接
       // shiroFilterFactoryBean.setSuccessUrl("/login/success");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }



//    @Bean
//    public  org.apache.shiro.mgt.SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        securityManager.setRealm(myShiroRealm);
//       // securityManager.setSessionManager(sessionManager());
//        //securityManager.setCacheManager(ehCacheManager());
//        return securityManager;
//    }
    @Bean(name = "myRealm")
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
}

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm")MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myShiroRealm);
        return manager;
    }
}
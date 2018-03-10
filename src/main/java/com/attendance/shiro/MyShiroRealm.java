package com.attendance.shiro;

import com.attendance.domain.UserInfo;
import com.attendance.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by pengm on 2018/2/23.
 */
public class MyShiroRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取用户名
        String userName = principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      //  Set<String> roleName = shiroUserDaoMapper.findRoles( userName );
       // Set<String> permissions = shiroUserDaoMapper.findPermissions( userName );

       // info.setRoles( roleName );
       // info.setStringPermissions( permissions );
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户账号
        String userName = authenticationToken.getPrincipal().toString() ;
       // ShiroUserEntity shiroUser = shiroUserDaoMapper.findUserByUserName( userName );
      //  if( shiroUser == null ) {
     //       return null;
       // }

        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword("123");
        // 将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realmName。
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo( userInfo.getUserName(), userInfo.getPassword(),
                getName() );
        return authenticationInfo;
    }
}
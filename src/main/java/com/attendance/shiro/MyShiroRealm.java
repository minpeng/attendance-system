package com.attendance.shiro;

import com.attendance.common.enums.RoleEnum;
import com.attendance.convert.UserPermissionConvert;
import com.attendance.domain.UserInfo;
import com.attendance.service.UserInfoService;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.UserPermissionVO;
import freemarker.template.utility.StringUtil;
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

import java.util.List;

/**
 * Created by pengm on 2018/2/23.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("--------------------------MyShiroRealm.doGetAuthorizationInfo-----------------------------" );
        String userName=(String) principals.getPrimaryPrincipal();

        UserInfo shiroUser = userInfoService.findUserByUserName(userName);
        if(shiroUser==null){
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        long userId = shiroUser.getId();

        //根据用户Id查询权限
        List<?> userPermissionList = userPermissionService.findOneByUserId(userId);
        UserPermissionVO userPermissionVO=UserPermissionConvert.getUserPermissionContent(userPermissionList).get(0);

        int role=userPermissionVO.getRoleId()==null? RoleEnum.USER.getRoleId():userPermissionVO.getRoleId();
        logger.info( "当前用户userId:" + userId + " role:" + role );

        info.addRole( String.valueOf( role ) );
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 把token转换成User对象
        UserInfo userToken = tokenToUser((UsernamePasswordToken) authenticationToken);
        // 验证用户是否可以登录
        String userName=userToken.getUserName();
        String password=userToken.getPassword();
        UserInfo userInfo = userInfoService.findUserByUserNameAndPassword(userName,password);
        if(userInfo == null) {
            return null; // 异常处理，找不到数据
        }
        //当前 Realm 的 name
        String realmName = this.getName();
        Object principal = authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(principal, userInfo.getPassword(), realmName);

    }

    private UserInfo tokenToUser(UsernamePasswordToken authcToken) {
        UserInfo user = new UserInfo();
        user.setUserName(authcToken.getUsername());
        user.setPassword(String.valueOf(authcToken.getPassword()));
        return user;
    }
}
package com.attendance.controller;

import com.attendance.domain.UserInfo;
import com.attendance.service.UserInfoService;
import org.apache.catalina.User;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by pengm on 2018/2/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = Logger.getLogger( LoginController.class );

    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/login")
    public  ModelAndView login(){

        return new ModelAndView("login/login");
    }
    @RequestMapping("/unauthorized")
    public  ModelAndView unauthorized(){

        return new ModelAndView("common/unauthorized");
    }
    @RequestMapping( value = "/logout" )
    public void logout(HttpServletRequest request, HttpServletResponse response ) {
        try {
            Subject subject = SecurityUtils.getSubject();
            String userName=(String)subject.getPrincipal();
            UserInfo shiroUser = userInfoService.findUserByUserName(userName);
            if( shiroUser == null || StringUtils.isEmpty(shiroUser.getUserName())) {
                response.sendRedirect("/login");
                return;
            }
            String userId = shiroUser.toString();
            if( subject.isAuthenticated() ){
                subject.logout();
            }

            response.sendRedirect("/login");
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    @RequestMapping("/loginSubmit")
    public ModelAndView index(UserInfo userInfo, Map<String,Object> map){

        Subject subject = SecurityUtils.getSubject();
        if(subject==null){
            return new ModelAndView("login/login");
        }
        logger.info(userInfo.getUserName() + ":" + userInfo.getPassword() );
        UsernamePasswordToken token = new UsernamePasswordToken( userInfo.getUserName(), userInfo.getPassword() );
        try {
            subject.login( token );
            map.put("msg","登录成功");
            map.put("url","/attendance/list");
            return new ModelAndView("common/success",map);
        }
        catch( Exception e ) {

            logger.error(e.getMessage());
            return new ModelAndView("login/login");
        }
    }
}
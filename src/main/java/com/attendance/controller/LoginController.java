package com.attendance.controller;

import com.attendance.domain.UserInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pengm on 2018/2/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = Logger.getLogger( LoginController.class );

    @RequestMapping("/login")
    public  ModelAndView login(){

        return new ModelAndView("login/login");
    }

    @RequestMapping("/loginSubmit")
    public ModelAndView index(UserInfo userInfo){
        System.out.print("1111");
        Subject subject = SecurityUtils.getSubject();
        if(subject==null){
            return new ModelAndView("login/login");
        }
        logger.info(userInfo.getUserName() + ":" + userInfo.getPassword() );
        UsernamePasswordToken token = new UsernamePasswordToken( userInfo.getUserName(), userInfo.getPassword() );
        try {
            subject.login( token );

            //model.addAttribute("shiroUser",shiroUser);
            return new ModelAndView("login/success");
        }
        catch( Exception e ) {
            // 这里将异常打印关闭是因为如果登录失败的话会自动抛异常
            // e.printStackTrace();

            return new ModelAndView("login/login");
        }
    }
}
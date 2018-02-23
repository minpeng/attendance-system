package com.attendance.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pengm on 2018/2/23.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("")
    public String index(@RequestParam("userName") String userName,
                        @RequestParam("password") String password){
        System.out.println("userName:"+userName);
        System.out.println("password:"+password);

        return  userName;
    }
}
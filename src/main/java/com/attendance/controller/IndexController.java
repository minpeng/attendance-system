package com.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pengm on 2018/2/23.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public ModelAndView index(){

        return new ModelAndView("login/login");
    }

    @RequestMapping("/login")
    public  ModelAndView index2(){

        return new ModelAndView("login/login");
    }
    @RequestMapping("/index")
    public  ModelAndView index3(){

        return new ModelAndView("login/login");
    }
}
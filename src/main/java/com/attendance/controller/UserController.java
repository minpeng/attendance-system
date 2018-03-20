package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserInfo;
import com.attendance.form.UserInfoForm;
import com.attendance.service.UserInfoService;
import com.attendance.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengm on 2018/3/2.
 */
@RestController
public class UserController {

    private  final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/user/list")
    public ModelAndView getUserInfoList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size,
                                        Map<String,Object> map){

        //TODO 加入是不是当前用户的判断
        PageRequest request = new PageRequest(page - 1, size);
        Page<UserInfo> userInfos = userInfoService.findList(request);
        map.put("userInfoPage", userInfos);
        map.put("currentPage", page);
        map.put("size", size);
        return  new ModelAndView("/user/list",map);
    }

    @RequestMapping("/user/index")
    public ModelAndView createUserInfo(@RequestParam(value = "id", required = false) Long id,
                                       Map<String, Object> map) {
       if (id != null) {
           UserInfo userInfo=userInfoService.findOne(id);
           map.put("userInfo", userInfo);
        }
        return new ModelAndView("user/index", map);
    }
    @RequestMapping("/user/save")
    public ModelAndView saveUserInfo(@Valid UserInfoForm userInfoForm,
                                     BindingResult bindingResult,
                                     Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", "保存用户信息失败");
            map.put("url", "/user/list");
            return  new ModelAndView("/common/error",map);
        }
        UserInfo userInfo=new UserInfo();
        BeanUtils.copyProperties(userInfoForm, userInfo);

        userInfoService.save(userInfo);

        map.put("msg", "保存用户信息成功");
        map.put("url", "/user/list");
        return  new ModelAndView("/common/success",map);
    }

    @RequestMapping("/user/editUser")
    public ModelAndView editUserInfo(@Valid UserInfoForm userInfoForm,
                                     BindingResult bindingResult,
                                     Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", "编辑用户信息失败");
            map.put("url", "/user/list");
            return  new ModelAndView("/common/error",map);
        }
        UserInfo userInfo=new UserInfo();
        BeanUtils.copyProperties(userInfoForm, userInfo);

        userInfoService.save(userInfo);

        map.put("msg", "编辑用户信息成功");
        map.put("url", "/user/list");
        return  new ModelAndView("/common/success",map);
    }

    @RequestMapping("/user/deleteUser")
    public ModelAndView deleteUserInfo(@RequestParam(value = "id") Long id,Map<String,Object> map){
        if(id<1){
            map.put("msg", "删除用户信息失败");
            map.put("url", "/user/list");
            return  new ModelAndView("/common/error",map);
        }
        userInfoService.delete(id);
        map.put("msg", "删除用户信息成功");
        map.put("url", "/user/list");
        return  new ModelAndView("/common/success",map);
    }
}
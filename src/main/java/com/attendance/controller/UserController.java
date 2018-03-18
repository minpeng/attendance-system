package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserInfo;
import com.attendance.form.UserInfoForm;
import com.attendance.service.UserInfoService;
import com.attendance.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by pengm on 2018/3/2.
 */
@RestController
public class UserController {

    private  final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/user/list")
    public ResultVO getUserInfoList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size){

        //TODO 加入是不是当前用户的判断
        PageRequest request = new PageRequest(page - 1, size);
        Page<UserInfo> userInfos = userInfoService.findList(request);
        return  ResultVOUtil.success(userInfos);
    }

    @RequestMapping("/user/createUser")
    public ResultVO createUserInfo(@Valid UserInfoForm userInfoForm,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("创建用户--参数不正确，userInfoForm={}", userInfoForm);
            return ResultVOUtil.error("参数不正确");
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(userInfoForm.getUserName());
        userInfo.setPassword(userInfoForm.getPassword());
        //TODO
        //userInfo.setCreateUser();
        userInfoService.insert(userInfo);
        return ResultVOUtil.success();
    }

    @RequestMapping("/user/editUser")
    public ResultVO editUserInfo(@RequestParam(value = "password") String password,
                                 @RequestParam(value = "id") Long id){
        if(id<1){
            return  ResultVOUtil.error();
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);

        if (!StringUtils.isEmpty(password)){
            userInfo.setPassword(password);

        }
        userInfoService.updatePassword(password,id);

        return  ResultVOUtil.success();
    }

    @RequestMapping("/user/deleteUser")
    public ResultVO deleteUserInfo(@RequestParam(value = "id") Long id){
        if(id<1){
            return  ResultVOUtil.error();
        }
        userInfoService.delete(id);
        return ResultVOUtil.success();
    }
}
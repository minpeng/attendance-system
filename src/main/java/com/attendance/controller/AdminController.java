package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserPermission;
import com.attendance.form.UserInfoForm;
import com.attendance.form.UserPermissionForm;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by pengm on 2018/3/2.
 * 管理设置
 */
@RestController
public class AdminController {
    @Autowired
    private UserPermissionService userPermissionService;

    @RequestMapping("/admin/createUserPermission")
    public ResultVO createUserPermission(@Valid UserPermissionForm userPermissionForm,
                                         BindingResult bindingResult){

        if(bindingResult.hasErrors()){
             return ResultVOUtil.error();
         }
         UserPermission userPermission=new UserPermission();
         userPermission.setUserId(userPermissionForm.getUserId());
         userPermission.setDepartmentId(userPermissionForm.getDepartmentId());
         userPermission.setRoleId(userPermissionForm.getRoleId());
         userPermissionService.insert(userPermission);
         return  ResultVOUtil.success();
    }

    @RequestMapping("/admin/edit")
    public ResultVO editUserPermission(){

        return  ResultVOUtil.success();
    }

    @RequestMapping("/admin/list")
    public ResultVO editUserPermission(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest request = new PageRequest(page - 1, size);
        userPermissionService.findList(request);
        return  ResultVOUtil.success();
    }

}
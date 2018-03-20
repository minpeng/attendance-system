package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.convert.UserAttendanceConvert;
import com.attendance.convert.UserPermissionConvert;
import com.attendance.domain.DepartmentInfo;
import com.attendance.domain.RoleInfo;
import com.attendance.domain.UserInfo;
import com.attendance.domain.UserPermission;
import com.attendance.form.UserInfoForm;
import com.attendance.form.UserPermissionForm;
import com.attendance.service.DepartmentInfoService;
import com.attendance.service.RoleInfoService;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.ResultVO;
import com.attendance.vo.UserPermissionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by pengm on 2018/3/2.
 * 管理设置
 */
@RestController
public class AdminController {
    @Autowired
    private UserPermissionService userPermissionService;
    @Autowired
    private DepartmentInfoService departmentInfoService;

    @Autowired
    private RoleInfoService roleInfoService;

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
         userPermissionService.save(userPermission);
         return  ResultVOUtil.success();
    }

    @RequestMapping("/admin/userPermissionIndex")
    public ModelAndView createUserInfo(@RequestParam(value = "userId", required = false) Long userId,
                                       Map<String, Object> map) {
        if (userId != null) {
            List<?> userPermission = userPermissionService.findOneByUserId(userId);
            map.put("userPermission", UserPermissionConvert.getUserPermissionContent(userPermission).get(0));

            //查询部门
            List<DepartmentInfo> departmentList = departmentInfoService.findList();
            map.put("departmentList", departmentList);

            //查询角色
            List<RoleInfo> roleList = roleInfoService.findList();
            map.put("roleList", roleList);
        }

        return new ModelAndView("admin/userPermissionIndex", map);
    }
    @RequestMapping("/admin/userPermissionSave")
    public ModelAndView editUserPermission(@Valid UserPermissionForm userPermissionForm,
                                       BindingResult bindingResult,
                                       Map<String ,Object> map){

        if (bindingResult.hasErrors()){
            map.put("msg", "保存用户权限信息失败");
            map.put("url", "/admin/userPermissionList");
            return  new ModelAndView("/common/error",map);
        }
        UserPermission userPermission=new UserPermission();
        BeanUtils.copyProperties(userPermissionForm, userPermission);

        userPermissionService.save(userPermission);

        map.put("msg", "保存用户权限信息成功");
        map.put("url", "/admin/userPermissionList");
        return  new ModelAndView("/common/success",map);
    }

    @RequestMapping("/admin/userPermissionList")
    public ModelAndView getUserPermissionList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size,
                                              Map<String,Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<?> userPermissionVOS= userPermissionService.findList(request);
        map.put("userPermissionPage", userPermissionVOS);
        map.put("userPermissionContent", UserPermissionConvert.getUserPermissionContent(userPermissionVOS));
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/admin/userPermissionList",map);

    }

}
package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.convert.UserAttendanceConvert;
import com.attendance.convert.UserInfoConvert;
import com.attendance.domain.UserAttendance;
import com.attendance.domain.UserInfo;
import com.attendance.service.UserAttendanceService;
import com.attendance.service.UserInfoService;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by pengmin on 2018/3/11.
 */
@RestController
public class ManagerController {
    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private UserAttendanceService userAttendanceService;

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 获取管理人员下属员工
     * @return
     */
    @RequestMapping("/manager/getUserInfo")
    public ModelAndView getUserInfo(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,

                                    Map<String,Object> map) {
        UserInfo currentUser = userInfoService.findUserByUserName((String) SecurityUtils.getSubject().getPrincipal()) ;
        long id=currentUser.getId();
        Pageable pageable=new PageRequest(page-1,size);
        Page<?> userInfos=userPermissionService.findUserInfoByManagerId(id,pageable);
        map.put("userInfoPage", userInfos);
        map.put("userInfoContent", UserInfoConvert.getUserInfoContent(userInfos));
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/manager/userInfoList",map);
    }

    @RequestMapping("/manager/getUserAttendance/{userId}")
    public ModelAndView getUserAttendacne(@PathVariable Long userId, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size,
                                      Map<String,Object> map){
        //TODO 判断该用户是否是部门经理

        if(StringUtils.isEmpty(userId)){
            map.put("msg", "查看用户打卡记录失败");
            map.put("url", "/manager/getUserInfo");
            return  new ModelAndView("/common/error",map);
        }

        Sort sort = new Sort(Sort.Direction.DESC, "date_time");
        Pageable request=new PageRequest(page-1,size,sort);
        Page<?> userAttendanceVOs = userAttendanceService.findList(userId,request);

        map.put("userAttendancePage", userAttendanceVOs);
        map.put("userAttendanceContent", UserAttendanceConvert.getUserAttendancePage(userAttendanceVOs));
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/manager/userAttendanceList",map);


    }
}

package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserAttendance;
import com.attendance.service.UserAttendanceService;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pengmin on 2018/3/11.
 */
@RestController
public class ManagerController {
    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private UserAttendanceService userAttendanceService;
    /**
     * 获取管理人员下属员工
     * @return
     */
    @RequestMapping("/manager/getUserInfo")
    public ResultVO getUserInfo(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size){
        long id=3L;
        Pageable pageable=new PageRequest(page,size);
        Page<?> userInfos=userPermissionService.findUserInfoByManagerId(id,pageable);
        return ResultVOUtil.success(userInfos);
    }

    @RequestMapping("/manager/getUserAttendacne/{userId}")
    public ResultVO getUserAttendacne(@PathVariable String userId, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(userId)){
            return  ResultVOUtil.error();
        }

        long id=3L;
        Pageable pageable=new PageRequest(page,size);
        Page<?> userInfos=userAttendanceService.findList(pageable);
        return ResultVOUtil.success(userInfos);
    }
}

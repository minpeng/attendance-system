package com.attendance.controller;

import com.attendance.common.contants.DateTimeFormatConstants;
import com.attendance.common.utils.DateTimeUtils;
import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserAttendance;
import com.attendance.domain.UserInfo;
import com.attendance.service.UserAttendanceService;
import com.attendance.vo.ResultVO;
import com.attendance.vo.UserAttendanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by pengm on 2018/3/2.
 *
 */
@RestController
public class AttendanceController {
    private Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    private UserAttendanceService userAttendanceService;

    @RequestMapping("/attendance/list")
    public Object getUserAttendanceList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest request = new PageRequest(page - 1, size);
        Page<UserAttendanceVO> userAttendanceVOs = userAttendanceService.findList(request);
        return ResultVOUtil.success(userAttendanceVOs);
    }

    @RequestMapping("/attendance/doAttendance")
    public ResultVO doAttendance(){
        //TODO
        long userId=2L;
        Date dateTime=DateTimeUtils.getTodayDate(DateTimeFormatConstants.YEARMONTHDAY);
        UserAttendance userAttendance=userAttendanceService.findByUserIdAndDateTime(userId,dateTime);

        if(userAttendance==null){
            //打卡签到
            userAttendance=new UserAttendance();
            userAttendance.setUserId(userId);
            userAttendance.setDateTime(dateTime);
            userAttendance.setId(userId);
            userAttendance.setSignInTime(new Date());

        }else{
            //打卡签退
            userAttendance.setSignOffTime(new Date());
        }
        userAttendanceService.insert(userAttendance);


        return  ResultVOUtil.success();
    }
}
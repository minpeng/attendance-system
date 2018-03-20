package com.attendance.controller;

import com.attendance.common.contants.DateTimeFormatConstants;
import com.attendance.common.utils.DateTimeUtils;
import com.attendance.common.utils.ResultVOUtil;
import com.attendance.convert.UserAttendanceConvert;
import com.attendance.domain.UserAttendance;
import com.attendance.domain.UserInfo;
import com.attendance.service.UserAttendanceService;
import com.attendance.service.UserInfoService;
import com.attendance.vo.ResultVO;
import com.attendance.vo.UserAttendanceVO;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by pengm on 2018/3/2.
 *
 */
@RestController
public class AttendanceController {
    private Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    private UserAttendanceService userAttendanceService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/attendance/list")
    public ModelAndView getUserAttendanceList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size,
                                              Map<String, Object> map){
        UserInfo currentUser = userInfoService.findUserByUserName((String) SecurityUtils.getSubject().getPrincipal()) ;
        Long userId=currentUser.getId();
        PageRequest request = new PageRequest(page - 1, size);
        Page<?> userAttendanceVOs = userAttendanceService.findList(userId,request);

        map.put("userAttendancePage", userAttendanceVOs);
        map.put("userAttendanceContent", UserAttendanceConvert.getUserAttendancePage(userAttendanceVOs));
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/attendance/list",map);
    }

    @RequestMapping("/attendance/doAttendance")
    public ModelAndView doAttendance(Map<String ,Object> map){
        UserInfo currentUser = userInfoService.findUserByUserName((String) SecurityUtils.getSubject().getPrincipal()) ;
        long userId=currentUser.getId();
        Date dateTime=DateTimeUtils.getTodayDate(DateTimeFormatConstants.YEARMONTHDAY);
        UserAttendance userAttendance=userAttendanceService.findByUserIdAndDateTime(userId,dateTime);

        if(userAttendance==null){
            //打卡签到
            userAttendance=new UserAttendance();
            userAttendance.setUserId(userId);
            userAttendance.setDateTime(dateTime);
            userAttendance.setSignInTime(new Date());

        }else{
            //打卡签退
            userAttendance.setSignOffTime(new Date());
        }
        userAttendanceService.insert(userAttendance);

        map.put("msg", "打卡成功");
        map.put("url", "/attendance/list");
        return  new ModelAndView("/common/success",map);
    }
}
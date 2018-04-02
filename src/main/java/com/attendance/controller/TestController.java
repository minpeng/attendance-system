package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserAttendance;
import com.attendance.domain.UserInfo;
import com.attendance.mapper.UserInfoMapper;
import com.attendance.service.UserAttendanceService;
import com.attendance.vo.ResultVO;
import com.attendance.vo.UserAttendanceInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pengm on 2018/3/28.
 */
@RestController
public class TestController {
    private  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserAttendanceService userAttendanceService;

    @RequestMapping("/test/list")

    public ResultVO attendanceList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest request = new PageRequest(page - 1, size);
        Page<UserAttendanceInterface> list=userAttendanceService.findAttendanceInterfaceList(request);

        return ResultVOUtil.success(list);
    }

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/getUsers")
    public List<UserInfo> getUsers() {
        List<UserInfo> users=userInfoMapper.getAll();
        return users;
    }

    @RequestMapping("/page/list")
    public Object getUsersPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "2") Integer size) {
        PageHelper.startPage(page,size,"id desc");
        List<UserInfo> users=userInfoMapper.getAll();
        PageInfo<UserInfo> pageList = new PageInfo<>(users);
        return pageList;
    }
}
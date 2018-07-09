package com.attendance.controller;

import com.attendance.common.utils.ResultVOUtil;
import com.attendance.domain.UserInfo;
import com.attendance.service.UserInfoService;
import com.attendance.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by pengm on 2018/7/9.
 */

@RestController
public class RestfulDemoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResultVO getUserInfoList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                    Map<String,Object> map){

        PageRequest request = new PageRequest(page - 1, size);
        Page<UserInfo> userInfos = userInfoService.findList(request);
        map.put("userInfoPage", userInfos);
        map.put("currentPage", page);
        map.put("size", size);
        return ResultVOUtil.success(userInfos);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResultVO getUserById (@PathVariable(value = "id") Long id) {

        UserInfo userInfo= userInfoService.findOne(id);
        return ResultVOUtil.success(userInfo);
    }
}
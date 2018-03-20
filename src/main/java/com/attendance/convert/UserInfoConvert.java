package com.attendance.convert;

import com.attendance.vo.UserAttendanceVO;
import com.attendance.vo.UserInfoVO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
public class UserInfoConvert {
    public static List<UserInfoVO> getUserInfoContent(Page<?> userInfos) {

        List<UserInfoVO> userInfoVOS = new ArrayList<>();

        List<?> userInfoVOList = userInfos.getContent();
        UserInfoVO userInfoVO=null;
        if (userInfoVOList != null) {
            for (int i = 0; i < userInfoVOList.size(); i++) {
                Object[] objects = (Object[]) userInfoVOList.get(i);
                userInfoVO = new UserInfoVO();
                userInfoVO.setId(Long.parseLong(objects[0].toString()));
                userInfoVO.setUserName((String) objects[1]);
                userInfoVO.setAge(Integer.parseInt(objects[2].toString()));
                userInfoVO.setSex((String) objects[1]);
                userInfoVOS.add(userInfoVO);
            }
        }
        return userInfoVOS;
    }
}
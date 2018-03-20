package com.attendance.convert;

import com.attendance.domain.UserAttendance;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
public class UserAttendanceConvert {

    public static List<UserAttendanceVO> getUserAttendancePage(Page<?> userAttendces) {

        List<UserAttendanceVO> userAttendanceVOS = new ArrayList<>();

        List<?> userAttendanceVOList = userAttendces.getContent();
        UserAttendanceVO userAttendanceVO=null;
        if (userAttendanceVOList != null) {
            for (int i = 0; i < userAttendanceVOList.size(); i++) {
                Object[] objects = (Object[]) userAttendanceVOList.get(i);
                userAttendanceVO = new UserAttendanceVO();
                userAttendanceVO.setUserName((String) objects[0]);
                userAttendanceVO.setDateTime(((Date) objects[1]));
                userAttendanceVO.setSignInTime((Date) objects[2]);
                userAttendanceVO.setSignOffTime((Date) objects[3]);
                userAttendanceVOS.add(userAttendanceVO);
            }
        }
        return userAttendanceVOS;
    }

}
package com.attendance.convert;

import com.attendance.vo.UserInfoVO;
import com.attendance.vo.UserPermissionVO;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
public class UserPermissionConvert {

    public static List<UserPermissionVO> getUserPermissionContent(Page<?> userPermissions) {

        List<UserPermissionVO> userPermissionVOS = new ArrayList<>();

        List<?> userPermissionList = userPermissions.getContent();
        if (!userPermissionList.isEmpty()){
            userPermissionVOS=getUserPermissionVOList(userPermissionList);
        }


        return userPermissionVOS;
    }



    public static List<UserPermissionVO> getUserPermissionContent(List<?> userPermissionList) {

        List<UserPermissionVO> userPermissionVOS = new ArrayList<>();

        if(!userPermissionList.isEmpty()){
            userPermissionVOS=getUserPermissionVOList(userPermissionList);
        }
        return userPermissionVOS;
    }

    private static List<UserPermissionVO> getUserPermissionVOList(List<?> userPermissionList) {
        List<UserPermissionVO> userPermissionVOS=new ArrayList<>();
        UserPermissionVO userPermissionVO=null;
        for (int i = 0; i < userPermissionList.size(); i++) {
            Object[] objects = (Object[]) userPermissionList.get(i);
            userPermissionVO = new UserPermissionVO();
            userPermissionVO.setId(StringUtils.isEmpty(objects[0])?null:Long.parseLong(objects[0].toString()));
            userPermissionVO.setUserId(StringUtils.isEmpty(objects[1])?null:Long.parseLong(objects[1].toString()));
            userPermissionVO.setUserName((String) objects[2]);
            userPermissionVO.setRoleId(StringUtils.isEmpty(objects[3])?null:Integer.parseInt(objects[3].toString()));
            userPermissionVO.setRoleName((String) objects[4]);
            userPermissionVO.setDepartmentId(StringUtils.isEmpty(objects[5])?null:Integer.parseInt(objects[5].toString()));
            userPermissionVO.setDepartmentName((String) objects[6]);

            userPermissionVOS.add(userPermissionVO);
        }
        return  userPermissionVOS;
    }
}
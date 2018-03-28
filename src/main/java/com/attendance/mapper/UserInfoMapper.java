package com.attendance.mapper;

import com.attendance.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pengm on 2018/3/28.
 */

public interface UserInfoMapper {
    List<UserInfo> getAll();

    UserInfo getOne(Long id);



}
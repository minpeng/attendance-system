package com.attendance.service;

import com.attendance.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by pengm on 2018/3/12.
 */
public interface UserInfoService {
    Page<UserInfo> findList(Pageable pageable);

    void delete(Long id);
    int updatePassword(String password, Long id);

    UserInfo findOne(Long id);

    void save(UserInfo userInfo);

    UserInfo findUserByUserNameAndPassword(String userName, String password);

    UserInfo findUserByUserName(String userName);
}
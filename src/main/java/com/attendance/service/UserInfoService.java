package com.attendance.service;

import com.attendance.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by pengm on 2018/3/12.
 */
public interface UserInfoService {
    Page<UserInfo> findList(Pageable pageable);
    UserInfo insert(UserInfo userInfo);
    UserInfo update(UserInfo userInfo);
    void delete(Long id);
    int updatePassword(String password, Long id);

}
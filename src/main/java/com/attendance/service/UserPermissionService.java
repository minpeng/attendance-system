package com.attendance.service;

import com.attendance.domain.UserInfo;
import com.attendance.domain.UserPermission;
import com.attendance.vo.UserInfoVO;
import com.attendance.vo.UserPermissionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by pengmin on 2018/3/11.
 */
public interface UserPermissionService {

    Page<?> findList(Pageable pageable);

    Page<?> findUserInfoByManagerId(long id, Pageable pageable);

    void save(UserPermission userPermission);

    List<?> findOneByUserId(Long userId);
}

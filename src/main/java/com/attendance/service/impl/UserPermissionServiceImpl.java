package com.attendance.service.impl;

import com.attendance.domain.UserInfo;
import com.attendance.domain.UserPermission;
import com.attendance.repository.UserPermissionRepository;
import com.attendance.service.UserPermissionService;
import com.attendance.vo.UserInfoVO;
import com.attendance.vo.UserPermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengmin on 2018/3/11.
 */
@Service("userPermissionService")
public class UserPermissionServiceImpl implements UserPermissionService {
    @Autowired
    private UserPermissionRepository userPermissionRepository;
    public UserPermissionServiceImpl() {
        super();
    }


    @Override
    public Page<?> findList(Pageable pageable) {
        return userPermissionRepository.findList(pageable);
    }

    @Override
    public Page<?> findUserInfoByManagerId(long id, Pageable pageable) {
        return userPermissionRepository.findUserInfoByManagerId(id,pageable);
    }

    @Override
    public List<?> findOneByUserId(Long userId) {
        return userPermissionRepository.findOneByUserId(userId);
    }

    @Override
    public void save(UserPermission userPermission) {
        userPermissionRepository.save(userPermission);
    }
}

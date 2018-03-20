package com.attendance.service.impl;

import com.attendance.domain.RoleInfo;
import com.attendance.repository.RoleInfoRepository;
import com.attendance.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoRepository roleRepository;

    @Override
    public List<RoleInfo> findList() {
        return roleRepository.findAll();
    }
}
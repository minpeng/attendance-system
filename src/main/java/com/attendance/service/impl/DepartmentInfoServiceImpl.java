package com.attendance.service.impl;

import com.attendance.domain.DepartmentInfo;
import com.attendance.repository.DepartmentInfoRepository;
import com.attendance.service.DepartmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
@Service("departmentInfoService")
public class DepartmentInfoServiceImpl implements DepartmentInfoService {
    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;
    @Override
    public List<DepartmentInfo> findList() {
        return departmentInfoRepository.findAll();
    }
}
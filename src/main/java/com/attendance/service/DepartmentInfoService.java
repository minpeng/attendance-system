package com.attendance.service;

import com.attendance.domain.DepartmentInfo;

import java.util.List;

/**
 * Created by pengm on 2018/3/18.
 */
public interface DepartmentInfoService {
    List<DepartmentInfo> findList();
}
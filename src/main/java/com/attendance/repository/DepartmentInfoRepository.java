package com.attendance.repository;

import com.attendance.domain.DepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pengm on 2018/3/18.
 */
public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, Long> {
}
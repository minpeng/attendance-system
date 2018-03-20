package com.attendance.repository;

import com.attendance.domain.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pengm on 2018/3/18.
 */
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {
}
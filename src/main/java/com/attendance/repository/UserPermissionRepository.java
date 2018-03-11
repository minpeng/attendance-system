package com.attendance.repository;

import com.attendance.domain.UserInfo;
import com.attendance.domain.UserPermission;
import com.attendance.vo.UserInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by pengmin on 2018/3/11.
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {


    @Query(value = "SELECT t2.* FROM t_user_permission AS t1,t_user_info AS t2 WHERE role_id=3 AND " +
            "department_id =(SELECT department_id FROM t_user_permission WHERE role_id =2  AND user_id= ?1 LIMIT 1)" +
            "AND t1.user_id =t2.id ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT t2.user_name,t1.id FROM t_user_permission AS t1,t_user_info AS t2 WHERE role_id=3 AND " +
                    "department_id =(SELECT department_id FROM t_user_permission WHERE role_id =2  AND user_id= ?1 LIMIT 1)" +
                    "AND t1.user_id =t2.id ORDER BY ?#{#pageable}) as t",
            nativeQuery = true)
    Page<UserInfo> findUserInfoByManagerId (long id, Pageable pageable);
}

package com.attendance.repository;

import com.attendance.domain.UserPermission;
import com.attendance.vo.UserPermissionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by pengmin on 2018/3/11.
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {


    @Query(value = "SELECT t2.id,t2.user_name,t2.age,t2.sex FROM t_user_permission AS t1,t_user_info AS t2 WHERE role_id=1 AND " +
            "department_id =(SELECT department_id FROM t_user_permission WHERE role_id =2  AND user_id= ?1 LIMIT 1)" +
            "AND t1.user_id =t2.id ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT t2.* FROM t_user_permission AS t1,t_user_info AS t2 WHERE role_id=1 AND " +
                    "department_id =(SELECT department_id FROM t_user_permission WHERE role_id =2  AND user_id= ?1 LIMIT 1)" +
                    "AND t1.user_id =t2.id ORDER BY ?#{#pageable}) as t",
            nativeQuery = true)
    Page<?> findUserInfoByManagerId (long id, Pageable pageable);

    @Query(value = "SELECT t4.id as id,t1.id as user_id,t1.user_name as user_name,t4.role_id,t3.role_name,t4.department_id,t2.department_name" +
            " FROM  t_user_info AS t1 left join  t_user_permission as t4 on t1.id=t4.user_id left join t_department_info AS t2 on t2.id=t4.department_id" +
            " left join t_role_info as t3 on t3.id=t4.role_id ORDER BY ?#{#pageable}",
            countQuery ="SELECT count(*) FROM (SELECT t4.id as id,t1.id as user_id,t1.user_name as user_name,t4.role_id,t3.role_name,t4.department_id,t2.department_name" +
                    " FROM  t_user_info AS t1 left join  t_user_permission as t4 on t1.id=t4.user_id left join t_department_info AS t2 on t2.id=t4.department_id" +
                    " left join t_role_info as t3 on t3.id=t4.role_id ) as t",
            nativeQuery =true)
    Page<?> findList(Pageable pageable);

    @Query(value = "select t.* from (SELECT t4.id as id,t1.id as user_id,t1.user_name as user_name,t4.role_id,t3.role_name,t4.department_id,t2.department_name" +
            " FROM t_user_info AS t1 left join  t_user_permission as t4 on t1.id=t4.user_id left join t_department_info AS t2 on t2.id=t4.department_id" +
            " left join t_role_info as t3 on t3.id=t4.role_id ) as t where t.user_id=?1",
            nativeQuery =true)
    List<?> findOneByUserId(Long userId);
}

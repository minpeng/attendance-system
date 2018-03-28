package com.attendance.repository;

import com.attendance.domain.UserAttendance;
import com.attendance.vo.UserAttendanceInterface;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */
public interface UserAttendanceRepository extends JpaRepository<UserAttendance, Long> {


    @Query(value = "SELECT  t1.user_name ,t2.date_time, t2.sign_in_time,t2.sign_off_time " +
            "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT  t1.user_name ,t2.date_time,t2.sign_in_time,t2.sign_off_time " +
                    "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id) as t",
            nativeQuery = true)
    Page<?> findList(Pageable pageable);


    UserAttendance findByUserId(Long userId);

    UserAttendance findByUserIdAndDateTime(Long userId,Date dateTime);

    @Query(value = "SELECT  t1.user_name ,t2.date_time, t2.sign_in_time,t2.sign_off_time " +
            "FROM t_user_attendance as t2 ,t_user_info as t1 WHERE t1.id=t2.user_id and t1.id=:userId ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT  t1.user_name ,t2.date_time,t2.sign_in_time,t2.sign_off_time " +
                    "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id and t1.id=?1) as t",
            nativeQuery = true)
    Page<?> findListByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query(value = "SELECT  t2.date_time ,t2.sign_in_time ,t2.sign_off_Time ,t1.user_name " +
            "FROM t_user_attendance as t2 ,t_user_info as t1 WHERE t1.id=t2.user_id  ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT  t1.user_name ,t2.date_time,t2.sign_in_time,t2.sign_off_time " +
                    "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id and ) as t",
            nativeQuery = true)
    Page<UserAttendanceInterface> findAttendanceInterfaceList(Pageable pageable);
}

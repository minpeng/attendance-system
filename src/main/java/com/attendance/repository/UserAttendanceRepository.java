package com.attendance.repository;

import com.attendance.domain.UserAttendance;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */
public interface UserAttendanceRepository extends JpaRepository<UserAttendance, Long> {


    @Query(value = "SELECT  t1.user_name ,t2.date_time,t2.sign_in_time,t2.sign_off_time " +
            "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT  t1.user_name ,t2.date_time,t2.sing_in_time,t2.sing_off_time " +
                    "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.status=1 and t1.id=t2.user_id) as t",
            nativeQuery = true)
    Page<UserAttendanceVO> findList(Pageable pageable);


    UserAttendance findByUserId(Long userId);

    UserAttendance findByUserIdAndDateTime(Long userId,Date dateTime);
}

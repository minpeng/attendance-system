package com.attendance.repository;

import com.attendance.domain.UserInfo;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by pengmin on 2018/3/3.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>  {



    UserInfo findAllByUserNameAndPassword(String userName,String password);

    @Transactional
    @Modifying
    @Query(value = "update t_user_info u set u.password = ?1 where u.id = ?2",nativeQuery = true)
    int updatePassword(String password,long id);


        @Query(value = "SELECT  t1.user_name ,t2.date_time,t2.sing_in_time,t2.sing_off_time " +
            "FROM t_user_info as t1,t_user_attendance as t2 WHERE  t1.id=t2.user_id ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM (SELECT  t1.user_name ,t2.date_time,t2.sing_in_time,t2.sing_off_time " +
                    "FROM t_user_info as t1,t_user_attendance as t2 WHERE t1.id=t2.user_id) as t",
            nativeQuery = true)
        Page<UserAttendanceVO> findList(Pageable pageable);

    UserInfo findAllByUserName(String userName);

}

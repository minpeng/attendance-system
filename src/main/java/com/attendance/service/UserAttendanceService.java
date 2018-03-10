package com.attendance.service;

import com.attendance.domain.UserAttendance;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */
public interface UserAttendanceService {
    /** 查询列表. */
    Page<UserAttendanceVO> findList(Pageable pageable);

    UserAttendance findByUserId(long userId);

    UserAttendance findByUserIdAndDateTime(long userId,Date dateTime);

    UserAttendance insert(UserAttendance userAttendance);
}

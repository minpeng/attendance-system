package com.attendance.service.impl;

import com.attendance.domain.UserAttendance;
import com.attendance.repository.UserAttendanceRepository;
import com.attendance.service.UserAttendanceService;
import com.attendance.vo.UserAttendanceInterface;
import com.attendance.vo.UserAttendanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */
@Service("userAttendanceService")
public class UserAttendanceServiceImpl implements UserAttendanceService {

    @Autowired
    private UserAttendanceRepository userAttendanceReposiory;

    @Override
    public UserAttendance findByUserId(long userId) {
        return userAttendanceReposiory.findByUserId(userId);
    }

    @Override
    public Page<?> findList(Pageable pageable) {
        return userAttendanceReposiory.findList(pageable);
    }

    public UserAttendanceServiceImpl() {
        super();
    }

    @Override
    public Page<?> findList(Long userId, Pageable pageable) {
        return userAttendanceReposiory.findListByUserId(userId,pageable);
    }

    @Override
    public UserAttendance findByUserIdAndDateTime(long userId, Date dateTime) {
        return userAttendanceReposiory.findByUserIdAndDateTime(userId,dateTime);
    }

    @Override
    public UserAttendance insert(UserAttendance userAttendance) {
        return userAttendanceReposiory.save(userAttendance);
    }

    @Override
    public Page<UserAttendanceInterface> findAttendanceInterfaceList(Pageable pageable) {
        return userAttendanceReposiory.findAttendanceInterfaceList(pageable);
    }
}

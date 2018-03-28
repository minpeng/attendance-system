package com.attendance.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by pengm on 2018/3/28.
 */
public interface UserAttendanceInterface {

     String getUserName();
     @JsonFormat(pattern="yyyy-MM-dd")
     Date getDateTime();

     @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
     Date getSignInTime();
     @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
     Date getSignOffTime();



}

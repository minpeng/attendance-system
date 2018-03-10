package com.attendance.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 * 签到表
 */
@Entity
@Table(name="t_user_attendance")
@DynamicUpdate //动态跟新时间
public class UserAttendance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Date dateTime;

    private Date signInTime;

    private Date signOffTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignOffTime() {
        return signOffTime;
    }

    public void setSignOffTime(Date signOffTime) {
        this.signOffTime = signOffTime;
    }
}

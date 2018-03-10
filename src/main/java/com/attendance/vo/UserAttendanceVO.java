package com.attendance.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by pengmin on 2018/3/10.
 */

public class UserAttendanceVO {

    private String userName;

    private Date dateTime;

    private Date signInTime;

    private Date signOffTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

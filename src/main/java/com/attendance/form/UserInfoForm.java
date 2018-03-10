package com.attendance.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by pengmin on 2018/3/10.
 */
public class UserInfoForm {
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private transient  String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

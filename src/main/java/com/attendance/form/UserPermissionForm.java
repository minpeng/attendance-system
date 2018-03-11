package com.attendance.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by pengmin on 2018/3/11.
 */
public class UserPermissionForm {

    @Min(value=1)
    private long userId;

    @Min(value=1)
    private long roleId;

    @Min(value=1)
    private int departmentId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}

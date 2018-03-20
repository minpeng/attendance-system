package com.attendance.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by pengmin on 2018/3/11.
 */
public class UserPermissionForm {

    private Long id;

    @Min(value=1)
    private Long userId;

    @Min(value=1)
    private Long roleId;

    @Min(value=1)
    private Integer departmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}

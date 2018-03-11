package com.attendance.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by pengmin on 2018/3/11.
 * 用户权限
 */
@Entity
@Table(name="t_user_permission")
@DynamicUpdate //动态跟新时间
public class UserPermission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long roleId;

    private int departmentId;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}

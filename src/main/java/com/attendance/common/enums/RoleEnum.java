package com.attendance.common.enums;

/**
 * Created by pengm on 2018/3/19.
 */
public enum RoleEnum {
    USER( 1, "普通员工" ), MANAGER( 2, "部门经理" ), ADMIN( 3, "管理员" );

    RoleEnum(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    private int roleId;
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

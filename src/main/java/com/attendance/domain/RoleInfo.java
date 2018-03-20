package com.attendance.domain;

import javax.persistence.*;

/**
 * Created by pengm on 2018/3/18.
 */
@Entity
@Table(name="t_role_info")
public class RoleInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
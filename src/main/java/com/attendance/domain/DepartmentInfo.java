package com.attendance.domain;

import javax.persistence.*;

/**
 * Created by pengm on 2018/3/18.
 */
@Entity
@Table(name="t_department_info")
public class DepartmentInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
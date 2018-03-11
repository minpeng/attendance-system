package com.attendance.vo;

/**
 * Created by pengmin on 2018/3/11.
 */
public class UserInfoVO {
    public UserInfoVO(Long id,String userName){
        this.id=id;
        this.userName=userName;
    }
    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

package com.itheima.ssm.domain;

import java.util.List;

//对应users
public class UserInfo {

    private int id;
    private String email;
    private String username;
    private String password;
    private String phonenum;
    private int status;
    private String statusStr;//0:未开启 1：开启
    private List<Role> roles;

    public String getStatusStr() {

        return status==0?"未开启":"开启";
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

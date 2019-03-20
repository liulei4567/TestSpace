package com.wuwei.core.entity;

/**
 * @auther XuXin
 * @date 2019/3/14 11:01
 */
public class User extends BaseEntity{

    private String email;
    private  String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

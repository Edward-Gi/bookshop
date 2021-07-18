package com.project.domain.po;

import java.io.Serializable;



public class Appuser implements Serializable {
    // 声明属性
    private Integer userID;
    private String user_name;
    private String user_pwd;


    public Appuser() {}
    //给select用
    public Appuser(int userID,String user_name,String user_pwd)
    {
        this.userID=userID;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }
    // 给insert用
    public Appuser(String user_name,String user_pwd) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "Appuser{" +
                "userID=" + userID +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}

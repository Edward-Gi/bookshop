package com.project.domain.po;

import java.io.Serializable;

public class Customer implements Serializable {
    // 声明属性
    private Integer customerID;
    private int userID;
    private String customer_name;
    private String phone_number;
    private String address;



    public Customer() {}
    //给insert用
    public Customer(int userID,String customer_name,String phone_number,String address)
    {
        this.userID=userID;
        this.customer_name = customer_name;
        this.phone_number = phone_number;
        this.address=address;
    }
    // 给select用
    public Customer(Integer customerID, int userID, String customer_name, String phone_number, String address) {
        this.customerID=customerID;
        this.userID=userID;
        this.customer_name = customer_name;
        this.phone_number = phone_number;
        this.address=address;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", userID=" + userID +
                ", customer_name='" + customer_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

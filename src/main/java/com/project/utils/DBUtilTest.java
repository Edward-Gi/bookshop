package com.project.utils;

import com.project.domain.po.Customer;

import java.sql.*;

public class DBUtilTest extends DBUtil {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn  = DriverManager.getConnection(url, user, password);
        String sql = "select * from customer where customerID = 1";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if(rs != null) {
            {
                Customer customer = new Customer(rs.getInt("customerID"),rs.getInt("userID"),rs.getString("customer_name"),
                        rs.getString("phone_number"),rs.getString("address"));
                System.out.println(customer);
            }
        }
        else
            System.out.println("null");







    }

}

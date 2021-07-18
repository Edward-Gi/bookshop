package com.project.dao.jdbcImpl;

import com.project.dao.CustomerDao;
import com.project.domain.po.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends GenericBaseDao implements CustomerDao {
    @Override
    public Customer findById(Integer id) {
        Customer customer = null;
        try {
            this.getConnection();
            String sql = "select * from customer where customerID = ?";
            this.executeQuery(sql,id);
            if(rs!=null && rs.next())
            {
                customer = new Customer(rs.getInt("customerID"),rs.getInt("userID"),rs.getString("customer_name"),
                        rs.getString("phone_number"),rs.getString("address"));
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = null;

        try {
            this.getConnection();
            String sql = "select * from customer";
            this.executeQuery(sql);
            if(rs!=null)
            {
                customers = new ArrayList<>();
                while(rs.next())
                {
                    Customer customer = new Customer(rs.getInt("customerID"),rs.getInt("userID"),
                            rs.getString("customer_name"),rs.getString("phone_number"),
                            rs.getString("address"));
                    customers.add(customer);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customers;
    }

    @Override
    public List<Customer> findBySQL(String sql, Object... params) {
        List<Customer> customers = null;
        try {
            this.getConnection();
            this.executeQuery(sql,params);
            if(rs!=null)
            {
                customers = new ArrayList<>();
                while(rs.next())
                {
                    Customer customer = new Customer(rs.getInt("customerID"),rs.getInt("userID"),
                            rs.getString("customer_name"),rs.getString("phone_number"),
                            rs.getString("address"));
                    customers.add(customer);
                }
            }
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public int insert(Customer customer) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "insert into customer values(null,?,?,?,?)";
            this.executeUpdate(sql,customer.getUserID(),customer.getCustomer_name(),customer.getPhone_number(),
                    customer.getAddress());
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(Customer customer) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "update customer set userID = ?, customer_name = ?,phone_number = ?,address = ? where customerID = ?";
            this.executeUpdate(sql,customer.getUserID(),customer.getCustomer_name(),customer.getPhone_number(),
                    customer.getAddress(),customer.getCustomerID());
            res = result;
            this.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int delete(Customer customer) {
        return this.delete(customer.getCustomerID());
    }

    @Override
    public int delete(Integer id) {
        int res = -1;
        try {
            this.getConnection();
            String sql = "delete from customer where customerID = ?";
            this.executeUpdate(sql,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

}

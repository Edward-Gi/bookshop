package com.project.dao.jdbcImpl;

import com.project.dao.CustomerDao;
import com.project.domain.po.Customer;

import java.util.List;

public class CustomerDaoTest {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = customerDao.findById(1);
        System.out.println(customer);
        //int del_res = customerDao.delete(1);
        Customer customer3 = new Customer(1,2,"xxx","123","zzz");
        int mod_res = customerDao.update(customer3);
        List<Customer> customers = customerDao.findAll();
        for (Customer c:customers)
            System.out.println(c);
        Customer customer1 = new Customer(3,"xyy","13612121312","12宿");
        int res = customerDao.insert(customer1);

        System.out.println(res);
    }
}

package com.project.service.Impl;

import com.project.dao.CustomerDao;
import com.project.dao.jdbcImpl.CustomerDaoImpl;
import com.project.domain.po.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public boolean add(Customer customer) {
        boolean result = false;
        int res = -1;
        res = customerDao.insert(customer);
        if(res == 1)
            result = true;
        return result;
    }

    @Override
    public boolean remove(int id) {
        boolean result = false;
        int res = -1;
        res = customerDao.delete(id);
        if(res == 1)
            result = true;
        return result;
    }

    @Override
    public boolean modify(Customer customer) {
        boolean result = false;
        int res = -1;
        res = customerDao.update(customer);
        if(res == 1)
            result = true;
        return result;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}

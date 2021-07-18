package com.project.web.controller;

import com.project.domain.po.Customer;
import com.project.service.Impl.CustomerService;
import com.project.service.Impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    private CustomerService customerService = new CustomerServiceImpl();

    private Customer customer;

    public String add_customer()
    {
        boolean res = customerService.add(customer);
        if (res)
            return "success";
        else
            return "fail";
    }

    public String remove_customer(int id)
    {
        boolean res = customerService.remove(id);
        if (res)
            return "success";
        else
            return "fail";
    }

    public String modify_customer()
    {
        boolean res = customerService.modify(customer);
        if (res)
            return "success";
        else
            return "fail";
    }

    public List<Customer> showAllCustomer()
    {
        return customerService.findAll();
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

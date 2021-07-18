package com.project.service.Impl;

import com.project.domain.po.Customer;

import java.util.List;

public interface CustomerService {
    boolean add(Customer customer);
    boolean remove(int id);
    boolean modify(Customer customer);
    List<Customer> findAll();
}

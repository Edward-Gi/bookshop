package com.project.view;

import com.project.domain.po.Customer;
import com.project.web.controller.CustomerController;

public class CustomerView {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();

        int uerID = 1;
        String customer_name = "xyy";
        String phone_number = "138xxxxxxxx";
        String address = "12宿";

        Customer customer = new Customer();
        customer.setCustomer_name(customer_name);
        customer.setPhone_number(phone_number);
        customer.setAddress(address);

        customerController.setCustomer(customer);
        String resultView = customerController.add_customer();

    }
}

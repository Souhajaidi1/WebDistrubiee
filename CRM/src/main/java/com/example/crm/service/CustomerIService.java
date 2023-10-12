package com.example.crm.service;
import com.example.crm.entity.Customer;

import java.util.List;

public interface CustomerIService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer updatedCustomer);

    void deleteCustomer(Long id);
}
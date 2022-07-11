package com.academy.rest.service;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import com.academy.rest.repositories.CustomerRepository;
import com.academy.rest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;



    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();

    }

    public Customer getCustomerById(String id){
        return customerRepository.findById(id).isPresent() ?
                customerRepository.findById(id).get() : null;
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){



    }

    public Customer getCustomerDetails(String customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setCustomerName("customer1");
        customer.setCompanyName("company1");
        return customer;
    }

    public List<Customer> allCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCustomerId("001");
        customer.setCustomerName("customer1");
        customer.setCompanyName("company1");
        customers.add(customer);
        Customer customer1 = new Customer();
        customer.setCustomerId("002");
        customer1.setCustomerName("customer2");
        customer1.setCompanyName("company2");
        customers.add(customer1);
        return customers;
    }


    public Customer saveOrUpdate(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerId())){
            customerRepository.deleteById(customer.getCustomerId());
            return customerRepository.save(customer);
        }
        return customerRepository.save(customer);
    }


}

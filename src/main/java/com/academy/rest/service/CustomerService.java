package com.academy.rest.service;

import com.academy.rest.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers(){

        customers.add(new Customer("1551","Luigi","Fincons"));
        customers.add(new Customer("1551","Luigi","Fincons"));
        customers.add(new Customer("1551","Luigi","Fincons"));
        return customers;

    }

    public Customer getCustomerById(String id){
        List<Customer> customers1 = customers
                .stream()
                .filter(customer -> customer.getCustomerId()
                        .equals(id)).toList();
        return customers1.size()==0 ? null : customers1.get(0);
    }

    public void deleteCustomer(String id){
        List<Customer> operatedList = new ArrayList<>();
        customers.stream()
                .filter(customer -> customer.getCustomerId().equals(id))
                .forEach(operatedList::add);
        customers.removeAll(operatedList);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void updateCustomer(Customer customer){
        Customer customerToUpdate;
        customers.stream()
                .filter(customer1 -> customer1.getCustomerId().equals(customer.getCustomerId()))
                .forEach(customer1 -> {

                });

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
        customers.stream().forEach(customer1 -> {
            if(customer1.getCustomerId().equals(customer.getCustomerId()))
                customers.add(customers.indexOf(customer1),customer);
        });
        customers.add(customer);
        return customer;
    }


}

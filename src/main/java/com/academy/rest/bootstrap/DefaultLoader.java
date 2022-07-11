package com.academy.rest.bootstrap;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import com.academy.rest.repositories.CustomerRepository;
import com.academy.rest.repositories.OrderRepository;
import com.academy.rest.service.CustomerService;
import com.academy.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.stereotype.Component;

@Component
public class DefaultLoader implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer();
        customer.setCustomerName("customer1");
        customer.setCompanyName("company1");
        customerRepository.save(customer);

        Order order = new Order();
        order.setQuantity(4);
        order.setPrice(23.5d);
        order.setCustomer(customer);
        orderRepository.save(order);

        Order order1 = new Order();
        order1.setQuantity(2);
        order1.setPrice(55.5d);
        order1.setCustomer(customer);
        orderRepository.save(order1);

        Customer customer1 = new Customer();
        customer1.setCustomerName("customer2");
        customer1.setCompanyName("company2");
        customerRepository.save(customer1);

        Order order2 = new Order();
        order2.setQuantity(15);
        order2.setPrice(27d);
        order2.setCustomer(customer1);
        orderRepository.save(order2);

        Order order3 = new Order();
        order3.setQuantity(18);
        order3.setPrice(57d);
        order3.setCustomer(customer1);
        orderRepository.save(order3);


    }
}

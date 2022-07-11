package com.academy.rest.controller;

import com.academy.rest.api.CustomerApi;
import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import com.academy.rest.service.CustomerService;
import com.academy.rest.service.OrderService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<CollectionModel<Customer>> getAllCustomers() {

        List<Customer> customerLink = customerService.getAllCustomers();

        for (Customer customer : customerLink){
            Link selfLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
            Link toOrders = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customer.getCustomerId())).withRel("allOrders");
            customer.add(selfLink);
            customer.add(toOrders);
        }
        Link link = linkTo(CustomerController.class).withSelfRel();
        CollectionModel<Customer> result = CollectionModel.of(customerLink, link);
        return new ResponseEntity<>(result,HttpStatus.OK);


    }

    @Override
    public ResponseEntity<Customer> getCustomerById(String id) {

        try{
            Customer customer = customerService.getCustomerById(id);
            if(customer==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Link allCustomers = linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("allCustomer");
            customer.add(allCustomers);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @Override
    public ResponseEntity<String> deleteCustomer(String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer " + customerId + " deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> createCustomer(Customer newCustomer) {
        try{
            customerService.saveOrUpdate(newCustomer);
            return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(newCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<CollectionModel<Order>> getOrdersForCustomer(String customerId) {
        List<Order> ordersForCustomer = orderService.getAllOrdersForCustomer(customerId);
        for (Order order : ordersForCustomer){
            Link selfLink = linkTo(OrderController.class).slash(order.getOrderId()).withSelfRel();
            order.add(selfLink);
        }

        Link selfOrdersLink = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withSelfRel();
        CollectionModel<Order> result = CollectionModel.of(ordersForCustomer, selfOrdersLink);
        return new ResponseEntity<CollectionModel<Order>>(result,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        return null;
    }
}

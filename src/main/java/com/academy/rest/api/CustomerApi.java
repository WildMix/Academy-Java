package com.academy.rest.api;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/default")
public interface CustomerApi{

    @GetMapping
    ResponseEntity<CollectionModel<Customer>> getAllCustomers();

    @GetMapping(value = "{customerId}")
    ResponseEntity<Customer> getCustomerById(@PathVariable String id);

    @DeleteMapping("/{customerId}")
    ResponseEntity<String> deleteCustomer(@PathVariable String customerId);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer);
    @PutMapping()
    ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer);

    @GetMapping(value = "{customerId}/orders")
    ResponseEntity<CollectionModel<Order>> getOrdersForCustomer(@PathVariable String customerId);

}

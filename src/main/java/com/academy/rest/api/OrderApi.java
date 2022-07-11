package com.academy.rest.api;

import com.academy.rest.domain.Order;
import org.apache.coyote.Response;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/default")
public interface OrderApi {

    @GetMapping
    ResponseEntity<CollectionModel<Order>> getAllOrders();

    @GetMapping(value = "/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable String id);


}

package com.academy.rest.controller;

import com.academy.rest.api.OrderApi;
import com.academy.rest.domain.Order;
import com.academy.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "api/v1/orders")
public class OrderController implements OrderApi {

    @Autowired
    OrderService orderService;

    @Override
    public ResponseEntity<CollectionModel<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        Link link = linkTo(CustomerController.class).withSelfRel();
        CollectionModel<Order> result = CollectionModel.of(orders, link);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> getOrderById(String id) {
        try{
            Order order = orderService.getOrderById(id);
            if(order == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

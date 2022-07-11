package com.academy.rest.service;

import com.academy.rest.domain.Order;
import com.academy.rest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getAllOrdersForCustomer(String customerId){
        return orderRepository.findByCustomer_CustomerId(customerId);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(String id){
        return orderRepository.findById(id).isPresent() ?
                orderRepository.findById(id).get() : null;
    }



}

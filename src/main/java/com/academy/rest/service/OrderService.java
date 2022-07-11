package com.academy.rest.service;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {


    public List<Order> getAllOrdersForCustomer(String customerId){

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));

        return orders;


    }

    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115151",15,15));

        return orders;

    }

    public Order getOrderById(String id){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("115151",15,15));
        orders.add(new Order("115161",15,15));
        orders.add(new Order("114151",15,15));
        orders.add(new Order("115171",15,15));
        List<Order> orderById = orders.stream().filter(order -> order.getOrderId().equals(id)).toList();
        return orderById.size()>0 ?
                orderById.get(0) : null;
    }

}

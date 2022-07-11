package com.academy.rest.repositories;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends CrudRepository<Order,String> {

    @Override
    List<Order> findAll();

    @Override
    List<Order> findAllById(Iterable<String> strings);

    @Override
    Optional<Order> findById(String s);

    @Override
    <S extends Order> List<S> saveAll(Iterable<S> entities);

    List<Order> findByCustomer_CustomerId(String customerId);


}

package com.academy.rest.repositories;

import com.academy.rest.domain.Customer;
import com.academy.rest.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Override
    List<Customer> findAll();

    @Override
    List<Customer> findAllById(Iterable<String> strings);

    @Override
    Optional<Customer> findById(String s);

    @Override
    <S extends Customer> List<S> saveAll(Iterable<S> entities);

}

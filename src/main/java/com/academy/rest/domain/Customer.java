package com.academy.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends RepresentationModel<Order> {

    private String customerId;
    private String customerName;
    private String companyName;
}

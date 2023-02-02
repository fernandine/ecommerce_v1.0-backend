package com.ecommerce.udemy.services;

import com.ecommerce.udemy.Dtos.OrderDto;
import com.ecommerce.udemy.entities.Order;
import com.ecommerce.udemy.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Page<OrderDto> findByEmail(String email, Pageable pageable) {
        Page<Order> orders = repository.findByCustomerEmailOrderByDateCreatedDesc(email, pageable);
        Page<OrderDto> dto = orders.map(x -> new OrderDto(x));
        return dto;
    }
}

package com.ecommerce.udemy.services;

import com.ecommerce.udemy.dtos.OrderDto;
import com.ecommerce.udemy.entities.Order;
import com.ecommerce.udemy.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public Page<OrderDto> findByEmail(String email, Pageable pageable) {
        Page<Order> orders = repository.findByCustomerEmailOrderByDateCreatedDesc(email, pageable);
        Page<OrderDto> dto = orders.map(x -> new OrderDto(x));
        return dto;
    }
}

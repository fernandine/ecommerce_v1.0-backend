package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.OrderDto;
import com.ecommerce.udemy.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<OrderDto>> findSalesByEmail(
            @RequestParam(value = "email") String email, Pageable pageable) {
        return ResponseEntity.ok().body(service.findByEmail(email, pageable));
    }
}
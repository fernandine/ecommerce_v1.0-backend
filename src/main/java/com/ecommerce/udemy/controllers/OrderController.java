package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.OrderDto;
import com.ecommerce.udemy.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/search")
    public ResponseEntity<Page<OrderDto>> findSalesByEmail(
            @RequestParam(value = "email") String email, Pageable pageable) {
        return ResponseEntity.ok().body(service.findByEmail(email, pageable));
    }
}
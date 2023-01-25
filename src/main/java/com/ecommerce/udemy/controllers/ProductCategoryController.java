package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.Dtos.ProductCategoryDto;
import com.ecommerce.udemy.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @GetMapping
    public ResponseEntity<Page<ProductCategoryDto>> findAll(Pageable pageable) {
        Page<ProductCategoryDto> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }
}

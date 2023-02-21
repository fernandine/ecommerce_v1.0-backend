package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.ProductCategoryDto;
import com.ecommerce.udemy.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @GetMapping
    public ResponseEntity<Page<ProductCategoryDto>> findAllPaged(Pageable pageable) {
        Page<ProductCategoryDto> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }
}

package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.Dtos.ProductDto;
import com.ecommerce.udemy.entities.Product;
import com.ecommerce.udemy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductDto>> findByName(
            @RequestParam("name") String name,
            Pageable pageable )
    {
        Page<ProductDto> list = service.findByName(name.trim(), pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/search/categories")
    public ResponseEntity<Page<ProductDto>> findByCategoryId(@RequestParam("id") Long id, Pageable pageable){
        return ResponseEntity.ok().body(service.findByCategoryId(id, pageable));
    }
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<ProductDto> searchById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.navigateByUrl(id));
    }
}

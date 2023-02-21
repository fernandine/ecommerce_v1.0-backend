package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.CountryDto;
import com.ecommerce.udemy.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<List<CountryDto>> findAll() {
        List<CountryDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Long id) {
        CountryDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}

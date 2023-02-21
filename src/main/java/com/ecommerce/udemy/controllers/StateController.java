package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.StateDto;
import com.ecommerce.udemy.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {

    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<Page<StateDto>> findAllPaged(
            Pageable pageable) {
        return ResponseEntity.ok()
                .body(service.findAllPaged(pageable));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<StateDto>> findByCountryCode(@RequestParam("code") String code) {
        List<StateDto> list = service.findByCountryCode(code);
        return ResponseEntity.ok().body(list);
    }
}

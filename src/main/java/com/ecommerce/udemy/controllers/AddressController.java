package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.dtos.AddressDto;
import com.ecommerce.udemy.services.AddressService;
import com.ecommerce.udemy.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/adresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<AddressDto> consultaCep(@PathVariable String cep) {
        AddressDto dto = viaCepService.findByCep(cep);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll() {
        List<AddressDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<AddressDto> insert(@RequestBody AddressDto dto) {
        AddressDto newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@PathVariable Long id, @RequestBody AddressDto dto) {
        AddressDto newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

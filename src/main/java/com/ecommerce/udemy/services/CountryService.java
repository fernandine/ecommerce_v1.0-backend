package com.ecommerce.udemy.services;

import com.ecommerce.udemy.dtos.CountryDto;
import com.ecommerce.udemy.entities.Country;
import com.ecommerce.udemy.repositories.CountryRepository;
import com.ecommerce.udemy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    public List<CountryDto> findAll() {
        List<Country> list = repository.findAll();
        return list.stream().map(CountryDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CountryDto findById(Long id) {
        Optional<Country> obj = repository.findById(id);
        Country entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CountryDto(entity);
    }
}

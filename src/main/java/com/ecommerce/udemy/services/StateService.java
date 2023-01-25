package com.ecommerce.udemy.services;

import com.ecommerce.udemy.Dtos.StateDto;
import com.ecommerce.udemy.entities.State;
import com.ecommerce.udemy.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    @Transactional(readOnly = true)
    public Page<StateDto> findAllPaged(Pageable pageable) {
        Page<State> page = repository.findAll(pageable);
        return page.map(StateDto::new);

    }

    @Transactional(readOnly = true)
    public List<StateDto> findByCountryCode(String countryCode) {
        List<State> list = repository.findByCountryCode(countryCode);
        return list.stream().map(StateDto::new).collect(Collectors.toList());
    }
}

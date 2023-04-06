package com.ecommerce.udemy.services;

import com.ecommerce.udemy.dtos.AddressDto;
import com.ecommerce.udemy.entities.Address;
import com.ecommerce.udemy.entities.User;
import com.ecommerce.udemy.repositories.AddressRepository;
import com.ecommerce.udemy.services.exceptions.DatabaseException;
import com.ecommerce.udemy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;


    @Transactional(readOnly = true)
    public List<AddressDto> findAll() {
        List<Address> list = repository.findAll();
        return list.stream().map(x -> new AddressDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<AddressDto> findAllPaged(Pageable pageable) {
        Page<Address> list = repository.findAll(pageable);
        return list.map(x -> new AddressDto(x));
    }

    @Transactional
    public AddressDto insert(AddressDto dto) {
        Address entity = new Address();

        entity.setCep(dto.getCep());
        entity.setBairro(dto.getBairro());
        entity.setComplemento(dto.getComplemento());
        entity.setLogradouro(dto.getLogradouro());
        entity.setLocalidade(dto.getLocalidade());

        entity = repository.save(entity);
        return new AddressDto(entity);
    }

    @Transactional
    public AddressDto update(Long id, AddressDto dto) {
        try {
            Address entity = repository.getReferenceById(id);
            entity.setCep(dto.getCep());
            entity.setBairro(dto.getBairro());
            entity.setComplemento(dto.getComplemento());
            entity.setLogradouro(dto.getLogradouro());
            entity.setLocalidade(dto.getLocalidade());
            entity = repository.save(entity);
            return new AddressDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}

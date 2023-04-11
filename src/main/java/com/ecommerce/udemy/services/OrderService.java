package com.ecommerce.udemy.services;

import com.ecommerce.udemy.dtos.OrderDto;
import com.ecommerce.udemy.dtos.UserDto;
import com.ecommerce.udemy.entities.Order;
import com.ecommerce.udemy.entities.User;
import com.ecommerce.udemy.repositories.OrderRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list = orderRepository.findAll();
        return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }

    //BUSCA PAGINADA
    @Transactional(readOnly = true)
    public Page<OrderDto> findAllPaged(Pageable pageable) {
        Page<Order> list = orderRepository.findAll(pageable);
        return list.map(x -> new OrderDto(x));
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        Order entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new OrderDto(entity);
    }

    @Transactional
    public OrderDto insert(OrderDto dto) {
        Order entity = new Order();
        entity.setMoment(dto.getMoment());
        entity.setStatus(dto.getStatus());
        entity = orderRepository.save(entity);
        return new OrderDto(entity);
    }

    @Transactional
    public OrderDto update(Long id, OrderDto dto) {
        try {
            Order entity = orderRepository.getReferenceById(id);
            entity.setMoment(dto.getMoment());
            entity.setStatus(dto.getStatus());

            return new OrderDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
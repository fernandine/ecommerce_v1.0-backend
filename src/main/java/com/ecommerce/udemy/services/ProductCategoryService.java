package com.ecommerce.udemy.services;

import com.ecommerce.udemy.Dtos.ProductCategoryDto;
import com.ecommerce.udemy.entities.ProductCategory;
import com.ecommerce.udemy.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductCategoryDto> findAllPaged(Pageable pageable) {
            Page<ProductCategory> page = repository.findAll(pageable);
            return page.map(x -> new ProductCategoryDto(x));
        }
    }

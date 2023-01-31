package com.ecommerce.udemy.services;

import com.ecommerce.udemy.Dtos.ProductDto;
import com.ecommerce.udemy.entities.Product;
import com.ecommerce.udemy.entities.ProductCategory;
import com.ecommerce.udemy.repositories.ProductCategoryRepository;
import com.ecommerce.udemy.repositories.ProductRepository;
import com.ecommerce.udemy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> list = repository.findAll();
        return list.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto navigateByUrl(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDto(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findByCategoryId(Long id, Pageable pageable) {
        ProductCategory category = (id == 0) ? null : categoryRepository.getReferenceById(id);
        Page<Product> page = repository.findByCategoryId(category, pageable);
        return page.map(ProductDto::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findByName(String name, Pageable pageable) {
        Page<Product> list = repository.findByName(name, pageable);
        return list.map(ProductDto::new);
    }
}

package com.ecommerce.udemy.repositories;

import com.ecommerce.udemy.entities.Product;
import com.ecommerce.udemy.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT obj FROM Product obj WHERE "
            +":category IS NULL OR obj.category IN :category")
    Page<Product> findByCategoryId(Category category, Pageable pageable);
    Page<Product> findByName(@Param("name") String name, Pageable pageable);

    @Query("SELECT obj FROM Product obj WHERE "
            + "(:notFavorite = false OR obj.favorite = false) ")
    List<Product> find(boolean notFavorite);
}

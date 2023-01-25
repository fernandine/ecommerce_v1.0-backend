package com.ecommerce.udemy.repositories;

import com.ecommerce.udemy.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

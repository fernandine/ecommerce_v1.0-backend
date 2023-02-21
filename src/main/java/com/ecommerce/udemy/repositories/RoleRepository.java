package com.ecommerce.udemy.repositories;

import com.ecommerce.udemy.entities.ERole;
import com.ecommerce.udemy.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

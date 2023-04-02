package com.ecommerce.udemy.repositories;

import com.ecommerce.udemy.entities.Role;
import com.ecommerce.udemy.entities.enums.StatusRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

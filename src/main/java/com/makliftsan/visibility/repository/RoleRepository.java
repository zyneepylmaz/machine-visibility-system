package com.makliftsan.visibility.repository;

import com.makliftsan.visibility.entity.Role;
import com.makliftsan.visibility.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
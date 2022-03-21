package com.example.coding_bat_jwt.repository;

import com.example.coding_bat_jwt.entity.Role;
import com.example.coding_bat_jwt.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(RoleEnum name);
}

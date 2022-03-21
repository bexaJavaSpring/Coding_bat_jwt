package com.example.coding_bat_jwt.repository;

import com.example.coding_bat_jwt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

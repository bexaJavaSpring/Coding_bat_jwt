package com.example.coding_bat_jwt.repository;

import com.example.coding_bat_jwt.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}

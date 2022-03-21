package com.example.coding_bat_jwt.repository;

import com.example.coding_bat_jwt.entity.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswers,Integer> {
}

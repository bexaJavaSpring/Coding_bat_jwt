package com.example.coding_bat_jwt.repository;

import com.example.coding_bat_jwt.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}

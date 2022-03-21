package com.example.coding_bat_jwt.service;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.CategoryDto;
import com.example.coding_bat_jwt.entity.Category;
import com.example.coding_bat_jwt.entity.Subject;
import com.example.coding_bat_jwt.repository.CategoryRepository;
import com.example.coding_bat_jwt.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final SubjectRepository subjectRepository;
    final CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setActive(dto.isActive());
        Optional<Subject> byId = subjectRepository.findById(dto.getSubject_id());
        category.setSubject(byId.get());
        Category save = categoryRepository.save(category);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, CategoryDto dto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found", false);
        }
        Category category = byId.get();
        category.setName(dto.getName());
        category.setActive(dto.isActive());
        Optional<Subject> byId1 = subjectRepository.findById(dto.getSubject_id());
        category.setSubject(byId1.get());
        Category save = categoryRepository.save(category);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        category.setActive(false);
        categoryRepository.save(category);
        return new ApiResponse("Blocked", true);
    }
}

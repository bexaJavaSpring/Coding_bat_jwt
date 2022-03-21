package com.example.coding_bat_jwt.service;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.QuestionDto;
import com.example.coding_bat_jwt.entity.Category;
import com.example.coding_bat_jwt.entity.Question;
import com.example.coding_bat_jwt.repository.CategoryRepository;
import com.example.coding_bat_jwt.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
 final QuestionRepository questionRepository;
 final CategoryRepository categoryRepository;

    public ApiResponse add(QuestionDto dto) {
        Question question=new Question();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setPoint(dto.getPoint());
        question.setCorrect_answer_description(dto.getCorrect_answer_description());
        Optional<Category> byId = categoryRepository.findById(dto.getCategory_id());
        question.setCategory(byId.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, QuestionDto dto) {
        Optional<Question> byId = questionRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Question question = byId.get();
        question.setName(dto.getName());
        question.setDescription(dto.getDescription());
        question.setPoint(dto.getPoint());
        question.setCorrect_answer_description(dto.getCorrect_answer_description());
        Optional<Category> byId1 = categoryRepository.findById(dto.getCategory_id());
        question.setCategory(byId1.get());
        Question save = questionRepository.save(question);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Question> byId = questionRepository.findById(id);
        if(!byId.isPresent()){
            return new ApiResponse("Not found",false);
        }
        Question question = byId.get();
        questionRepository.delete(question);
        return new ApiResponse("Deleted",true);
    }
}

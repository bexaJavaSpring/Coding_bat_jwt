package com.example.coding_bat_jwt.controller;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.QuestionDto;
import com.example.coding_bat_jwt.repository.QuestionRepository;
import com.example.coding_bat_jwt.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/question")
@RestController
@RequiredArgsConstructor
public class QuestionController {
    final QuestionRepository questionRepository;
    final QuestionService questionService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(questionRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody QuestionDto dto){
        ApiResponse apiResponse=questionService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody QuestionDto dto){
        ApiResponse apiResponse=questionService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=questionService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }
}

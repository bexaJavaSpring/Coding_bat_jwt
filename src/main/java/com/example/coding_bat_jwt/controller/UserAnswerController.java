package com.example.coding_bat_jwt.controller;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.UserAnswerDto;
import com.example.coding_bat_jwt.repository.UserAnswerRepository;
import com.example.coding_bat_jwt.service.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/useranswer")
@RestController
@RequiredArgsConstructor
public class UserAnswerController {

    final UserAnswerRepository userAnswerRepository;
    final UserAnswerService userAnswerService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(userAnswerRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody UserAnswerDto dto){
        ApiResponse apiResponse=userAnswerService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody UserAnswerDto dto){
        ApiResponse apiResponse=userAnswerService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}

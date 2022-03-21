package com.example.coding_bat_jwt.controller;

import com.example.coding_bat_jwt.dto.AnswerDto;
import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.repository.AnswerRepository;
import com.example.coding_bat_jwt.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.HttpCookie;

@RequestMapping("/api/answer")
@RestController
@RequiredArgsConstructor
public class AnswerController {
    final AnswerRepository answerRepository;
    final AnswerService answerService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(answerRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody AnswerDto dto){
        ApiResponse apiResponse=answerService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody AnswerDto dto){
        ApiResponse apiResponse=answerService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=answerService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }

}

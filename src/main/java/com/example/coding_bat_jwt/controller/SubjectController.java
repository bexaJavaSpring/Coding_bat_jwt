package com.example.coding_bat_jwt.controller;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.SubjectDto;
import com.example.coding_bat_jwt.repository.SubjectRepository;
import com.example.coding_bat_jwt.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/subject")
@RestController
@RequiredArgsConstructor
public class SubjectController {

    final SubjectRepository subjectRepository;
    final SubjectService subjectService;

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok().body(subjectRepository.findAll());
    }

    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody SubjectDto dto) {
        ApiResponse apiResponse = subjectService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody SubjectDto dto) {
        ApiResponse apiResponse = subjectService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = subjectService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 404).body(apiResponse);
    }
}

package com.example.coding_bat_jwt.service;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.SubjectDto;
import com.example.coding_bat_jwt.entity.Subject;
import com.example.coding_bat_jwt.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    final SubjectRepository subjectRepository;

    public ApiResponse add(SubjectDto dto) {
        Subject subject=new Subject();
        subject.setName(dto.getName());
        subject.setActive(dto.isActive());
        Subject save = subjectRepository.save(subject);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, SubjectDto dto) {
        Optional<Subject> byId = subjectRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Subject subject = byId.get();
        subject.setName(dto.getName());
        subject.setActive(dto.isActive());
        Subject save = subjectRepository.save(subject);
        return new ApiResponse("Edit",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Subject> byId = subjectRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Subject subject = byId.get();
        subjectRepository.delete(subject);
        return new ApiResponse("Delete",true);
    }
}

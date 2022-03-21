package com.example.coding_bat_jwt.service;

import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.dto.UserAnswerDto;
import com.example.coding_bat_jwt.entity.User;
import com.example.coding_bat_jwt.entity.UserAnswers;
import com.example.coding_bat_jwt.repository.UserAnswerRepository;
import com.example.coding_bat_jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAnswerService {

    final UserAnswerRepository userAnswerRepository;
    final UserRepository userRepository;

    public ApiResponse add(UserAnswerDto dto) {
        UserAnswers userAnswers=new UserAnswers();
        userAnswers.setYourself_answer(dto.getYourself_answer());
        Optional<User> byId = userRepository.findById(dto.getUser_id());
        userAnswers.setUser(byId.get());
        UserAnswers save = userAnswerRepository.save(userAnswers);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, UserAnswerDto dto) {
        Optional<UserAnswers> byId = userAnswerRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        UserAnswers userAnswers = byId.get();
        userAnswers.setYourself_answer(dto.getYourself_answer());
        Optional<User> byId1 = userRepository.findById(dto.getUser_id());
        userAnswers.setUser(byId1.get());
        userAnswerRepository.save(userAnswers);
        return new ApiResponse("Edited",true);
    }
}

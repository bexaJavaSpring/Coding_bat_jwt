package com.example.coding_bat_jwt.service;

import com.example.coding_bat_jwt.dto.AnswerDto;
import com.example.coding_bat_jwt.dto.ApiResponse;
import com.example.coding_bat_jwt.entity.Answer;
import com.example.coding_bat_jwt.entity.Question;
import com.example.coding_bat_jwt.repository.AnswerRepository;
import com.example.coding_bat_jwt.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    final AnswerRepository answerRepository;
    final QuestionRepository questionRepository;

    public ApiResponse add(AnswerDto dto) {
        Answer answer=new Answer();
        answer.setCorrect_answer(dto.getCorrect_answer());
        answer.setIncorrect_answer1(dto.getIncorrect_answer1());
        answer.setIncorrect_answer2(dto.getIncorrect_answer2());
        answer.setIncorrect_answer3(dto.getIncorrect_answer3());
        Optional<Question> byId = questionRepository.findById(dto.getQuestion_id());
        answer.setQuestion(byId.get());
        Answer save = answerRepository.save(answer);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, AnswerDto dto) {
        Optional<Answer> byId = answerRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Answer answer = byId.get();
        answer.setCorrect_answer(dto.getCorrect_answer());
        answer.setIncorrect_answer1(dto.getIncorrect_answer1());
        answer.setIncorrect_answer2(dto.getIncorrect_answer2());
        answer.setIncorrect_answer3(dto.getIncorrect_answer3());
        Optional<Question> byId1 = questionRepository.findById(dto.getQuestion_id());
        answer.setQuestion(byId1.get());
        Answer save = answerRepository.save(answer);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Answer> byId = answerRepository.findById(id);
        Answer answer = byId.get();
        answerRepository.delete(answer);
        return new ApiResponse("Deleted",true);
    }
}

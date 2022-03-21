package com.example.coding_bat_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAnswerDto {
    private String yourself_answer;
    private Integer user_id;
}

package com.example.coding_bat_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDto {
    private String name;
    private String description;
    private Double point;
    private String correct_answer_description;
    private Integer category_id;
}

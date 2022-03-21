package com.example.coding_bat_jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String correct_answer;
    private String incorrect_answer1;
    private String incorrect_answer2;
    private String incorrect_answer3;
    @OneToOne
    private Question question;
}

package org.example.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTitle;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String difficultLevel;
}

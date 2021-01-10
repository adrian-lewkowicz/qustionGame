package com.question.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "questions")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {
    @Id
    @Column(name = "questionId")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sec")
    private Long questionId;
    private String question;
    private String responseA;
    private String responseB;
    private String responseC;
    private String responseD;
    private String correct;
    private String categoryId;
    private String userEmail;
    private boolean approved;

}

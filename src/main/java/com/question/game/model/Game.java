package com.question.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "games")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game {
    @Id
    @Column(name = "gameId")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sec")
    private Long gameId;
    private int correctAnswers;
    private int numberOfQuestions;
    private Date date = new Date();
    private String userEmail;
}

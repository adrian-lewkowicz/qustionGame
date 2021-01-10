package com.question.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "categories")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
    @Id
    @Column(name = "categoryIdId")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sec")
    private Long categoryId;
    private String categoryName;
    private String categoryUrl;
}

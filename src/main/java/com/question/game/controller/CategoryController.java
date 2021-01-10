package com.question.game.controller;

import com.question.game.model.Category;
import com.question.game.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questiongame/api")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @CrossOrigin
    @GetMapping("/category/getlist")
    public List<Category> getListQuestions(Pageable pageable){
        return categoryRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/category/add")
    public Category createQuestion( @RequestBody Category question){
        Category question1 = categoryRepository.save(question);
        return question1;
    }
}

package com.question.game.controller;

import com.question.game.exception.ResourceNotFoundException;
import com.question.game.model.Question;
import com.question.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questiongame/api")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @CrossOrigin
    @PostMapping("/question/add")
    public Question createQuestion( @RequestBody Question question){
        Question question1 = questionRepository.save(question);
        return question1;
    }

    @CrossOrigin
    @GetMapping("/question/getlist")
    public Page<Question> getListQuestions(Pageable pageable){
        return questionRepository.findAll(pageable);
    }

    @CrossOrigin
    @GetMapping("/question/byid/{id}")
    public Question getById(@PathVariable Long id){
        return questionRepository.getOne(id);
    }
    @CrossOrigin
    @GetMapping("/question/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id){
        return questionRepository.findById(id).map(question -> {
            questionRepository.delete(question);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Question not found by Id" + id));
    }

}

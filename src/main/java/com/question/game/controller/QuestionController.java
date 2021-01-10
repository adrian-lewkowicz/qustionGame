package com.question.game.controller;

import com.question.game.exception.ResourceNotFoundException;
import com.question.game.model.Question;
import com.question.game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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
    @PutMapping("/question/update")
    public Question putQuestion( @RequestBody Question question){
        return questionRepository.save(question);
    }

    @CrossOrigin
    @GetMapping("/question/getlist")
    public List<Question> getListQuestions(){
        return questionRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/question/random/{categoryId}/{numberOfQuestions}")
    public List<Question> getRandomQuestions(@PathVariable String categoryId,
                                             @PathVariable int numberOfQuestions){
      /*  List<Question> questions = questionRepository.findAll();
        List<Question> randomQuestions = new ArrayList<>();
        List<Question> copy = new ArrayList<>(questions);

        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < Math.min(numberOfQuestions, questions.size()); i++) {
            randomQuestions.add( copy.remove( rand.nextInt( copy.size())));
        }
        return randomQuestions;*/
      return questionRepository.getRandomQuestions(categoryId, numberOfQuestions);
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

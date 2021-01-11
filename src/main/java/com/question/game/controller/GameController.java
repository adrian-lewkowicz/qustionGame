package com.question.game.controller;

import com.question.game.model.Game;
import com.question.game.model.Question;
import com.question.game.model.StatisticsUser;
import com.question.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questiongame/api")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @CrossOrigin
    @PostMapping("/game/add")
    public Game createGame(@RequestBody Game game){
        Game game1 = gameRepository.save(game);
        return game1;
    }

    @CrossOrigin
    @GetMapping("/game/userstats/{userEmail}/{daysToBack}")
    public Float getPercentGoodAnswers(@PathVariable String userEmail,
                                       @PathVariable int daysToBack){
        return gameRepository.getPercentGoodAnswers(userEmail, daysToBack);
    }

    @CrossOrigin
    @GetMapping("/game/userrank/{limit}")
    public List<StatisticsUser> getStaticsRanks(@PathVariable int limit){
        return gameRepository.getRanks(limit);
    }

}

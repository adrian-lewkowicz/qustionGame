package com.question.game.repository;

import com.question.game.model.Game;
import com.question.game.model.StatisticsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    @Query(nativeQuery=true,
            value="SELECT (SUM(correct_answers)*100/SUM(number_of_questions)*100)/100 FROM games WHERE user_email=:userEmail AND date > CURRENT_DATE - :daysToBack")
    Float getPercentGoodAnswers(@Param("userEmail")String userEmail, @Param("daysToBack") int daysToBack);

    @Query(nativeQuery=true,
            value="SELECT user_email, (SUM(correct_answers)*100/SUM(number_of_questions)*100)/100 AS \"percents\" FROM games GROUP BY user_email ORDER BY percents desc  LIMIT :howMuch")
    List<StatisticsUser> getRanks(@Param("howMuch") int limit);
}

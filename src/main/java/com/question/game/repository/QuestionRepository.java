package com.question.game.repository;

import com.question.game.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(nativeQuery=true,
            value="SELECT *  FROM questions WHERE category_id=:categoryId ORDER BY random() LIMIT :howMuch")
    List<Question> getRandomQuestions(@Param("categoryId")String categoryId,
                                      @Param("howMuch") int limit);

}

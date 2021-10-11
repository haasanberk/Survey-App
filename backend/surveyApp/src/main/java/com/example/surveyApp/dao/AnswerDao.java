package com.example.surveyApp.dao;

import com.example.surveyApp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AnswerDao extends CrudRepository<Answer,Integer> , JpaRepository<Answer, Integer> {

    @Query(value="SELECT COUNT(A.score) " +
            "FROM Answer AS A " +
            "INNER JOIN Survey AS S on A.survey_id= s.survey_id " +
            "inner JOIN Topic AS T on S.topic_id=T.topic_id " +
            "where A.score<=6 and T.topic_id=?1", nativeQuery = true)
    long getNegativeAnswerCount(int topic_id);

    @Query(value="SELECT COUNT(A.score) " +
            "FROM Answer AS A " +
            "INNER JOIN Survey AS S on A.survey_id= s.survey_id " +
            "inner JOIN Topic AS T on S.topic_id=T.topic_id " +
            "where A.score>=8 and T.topic_id=?1", nativeQuery = true)
    long getPositiveAnswerCount(int topic_id);

}

package com.example.surveyApp.service;

import com.example.surveyApp.dao.AnswerDao;
import com.example.surveyApp.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerDao answerDao;
    @Autowired
    public AnswerService(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public Answer createAnswer(Answer answer){
        return answerDao.save(answer);
    }

    public Iterable<Answer> getAllAnswers(){
        return answerDao.findAll();
    };

    public Optional<Answer> getAnswerById(int id){
        return answerDao.findById(id);
    };

    public long getPositiveAnswerCount(int topic_id){
        return answerDao.getPositiveAnswerCount(topic_id);
    };
    public long getNegativeAnswerCount(int topic_id){
        return answerDao.getNegativeAnswerCount(topic_id);
    };

    public void deleteAnswer(int id){
        answerDao.deleteById(id);
    };
}

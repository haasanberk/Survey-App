package com.example.surveyApp.service;

import com.example.surveyApp.dao.SurveyDao;
import com.example.surveyApp.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SurveyService {
    private final SurveyDao surveyDao;
    @Autowired
    public SurveyService( SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

    public Survey createSurvey(Survey survey){
        return surveyDao.save(survey);
    }

    public Iterable<Survey> getAllSurveys(){
        return surveyDao.findAll();
    };

    public Optional<Survey> getSurveyById(int id){
        return surveyDao.findById(id);
    };

    public void deleteSurvey(int id){
        surveyDao.deleteById(id);
    };
}

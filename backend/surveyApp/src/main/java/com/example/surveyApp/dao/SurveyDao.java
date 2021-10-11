package com.example.surveyApp.dao;

import com.example.surveyApp.model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyDao extends CrudRepository <Survey,Integer>{

}

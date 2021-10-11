package com.example.surveyApp.api;

import com.example.surveyApp.model.Survey;
import com.example.surveyApp.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/survey")
@RestController
public class SurveyController {
    private final SurveyService surveyService;

    @Autowired
    public SurveyController( SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public void createSurvey(@RequestBody Survey survey){
        surveyService.createSurvey(survey);
    }

    @GetMapping
    public Iterable<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @GetMapping(path = "{id}")
    public Survey getSurveyById(@PathVariable("id") int id){
        return surveyService.getSurveyById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSurvey(@PathVariable("id") int id){
        surveyService.deleteSurvey(id);
    }
}

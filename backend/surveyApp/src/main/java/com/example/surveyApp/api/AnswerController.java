package com.example.surveyApp.api;

import com.example.surveyApp.model.Answer;
import com.example.surveyApp.model.Survey;
import com.example.surveyApp.model.Topic;
import com.example.surveyApp.service.AnswerService;
import com.example.surveyApp.service.SurveyService;
import com.example.surveyApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/answer")
@RestController
public class AnswerController {
    private final AnswerService answerService;
    private final TopicService topicService;
    private final SurveyService surveyService;


    @Autowired
    public AnswerController(AnswerService answerService, TopicService topicService, SurveyService surveyService) {
        this.answerService = answerService;
        this.topicService = topicService;
        this.surveyService = surveyService;
    }

    @PostMapping
    public void createAnswer(@RequestBody Answer answer){
        answerService.createAnswer(answer);
        Survey survey = answer.getSurvey();
        survey = surveyService.getSurveyById(survey.getId()).get();
        Topic topic = survey.getTopic();

        long positive = answerService.getPositiveAnswerCount(topic.getId());
        long negative = answerService.getNegativeAnswerCount(topic.getId());
        int npmScore = (int)((positive-negative)*100/(positive+negative));

        topicService.updateNpmScore(topic.getId(), npmScore);
    }

    @GetMapping
    public Iterable<Answer> getAllAnswers(){
        return answerService.getAllAnswers();
    }

    @GetMapping(path = "{id}")
    public Answer getAnswerById(@PathVariable("id") int id){
        return answerService.getAnswerById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        answerService.deleteAnswer(id);
    }
}

package com.example.surveyApp.api;

import com.example.surveyApp.model.Topic;
import com.example.surveyApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/topic")
@RestController
public class TopicController {
    private final TopicService topicService;

    @Autowired
    public TopicController( TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public void createTopic(@RequestBody Topic topic){
        topicService.createTopic(topic);
    }

    @GetMapping
    public Iterable<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(path = "{id}")
    public Topic getTopicById(@PathVariable("id") int id){
        return topicService.getTopicById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTopic(@PathVariable("id") int id){
        topicService.deleteTopic(id);
    }
}

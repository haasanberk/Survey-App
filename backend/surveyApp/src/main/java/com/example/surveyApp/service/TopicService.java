package com.example.surveyApp.service;

import com.example.surveyApp.dao.TopicDao;
import com.example.surveyApp.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TopicService {
    private final TopicDao topicDao;
    @Autowired
    public TopicService(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public Topic createTopic(Topic topic){
        return topicDao.save(topic);
    }

    public Topic updateNpmScore(int id, int npm_score){
        Topic topic = getTopicById(id).get();
        topic.setNpm_score(npm_score);
        return topicDao.save(topic);
    }

    public Iterable<Topic> getAllTopics(){
        return topicDao.findAll();
    };

    public Optional<Topic> getTopicById(int id){
        return topicDao.findById(id);
    };

    public void deleteTopic(int id){
         topicDao.deleteById(id);
    };
}

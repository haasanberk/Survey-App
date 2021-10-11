package com.example.surveyApp.dao;

import com.example.surveyApp.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends CrudRepository<Topic,Integer> {



}

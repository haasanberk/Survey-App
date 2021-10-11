package com.example.surveyApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Survey")
public class Survey {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private int id;
    @ManyToOne()
    @JoinColumn(name="topic_id")
    private Topic topic;
    private  String question;

    public Topic getTopic() {
        return topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }



}

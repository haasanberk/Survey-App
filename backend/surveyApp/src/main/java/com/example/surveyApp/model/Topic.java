package com.example.surveyApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Topic")

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int id;
    private  String name;
    private  int npm_score;


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getNpm_score() {
        return npm_score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNpm_score(int npm_score) {
        this.npm_score = npm_score;
    }
}

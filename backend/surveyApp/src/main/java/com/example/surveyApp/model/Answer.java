package com.example.surveyApp.model;


import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="survey_id")
    private  Survey survey;
    private  int score;
    private  String feedback;

    public int getId() {
        return id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public int getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

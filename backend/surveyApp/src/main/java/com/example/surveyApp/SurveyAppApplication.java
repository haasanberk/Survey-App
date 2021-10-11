package com.example.surveyApp;

import com.example.surveyApp.dao.AnswerDao;
import com.example.surveyApp.dao.SurveyDao;
import com.example.surveyApp.dao.TopicDao;
import com.example.surveyApp.model.Answer;
import com.example.surveyApp.model.Survey;
import com.example.surveyApp.model.Topic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SurveyAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(SurveyAppApplication.class, args);

		TopicDao topicDao = configurableApplicationContext.getBean(TopicDao.class);
		SurveyDao surveyDao = configurableApplicationContext.getBean(SurveyDao.class);
		AnswerDao answerDao = configurableApplicationContext.getBean(AnswerDao.class);

		// Seed DB
		Topic topic1 = new Topic();
		topic1.setName("Service");
		topicDao.save(topic1);

		Topic topic2 = new Topic();
		topic2.setName("Speed");
		topicDao.save(topic2);

		Survey survey1 = new Survey();
		survey1.setTopic(topic1);
		survey1.setQuestion("How do you rate your overall satisfaction with our service?");
		surveyDao.save(survey1);

		Survey survey2 = new Survey();
		survey2.setTopic(topic1);
		survey2.setQuestion("How do you rate your satisfaction with the courier?");
		surveyDao.save(survey2);

		Survey survey3 = new Survey();
		survey3.setTopic(topic2);
		survey3.setQuestion("How do you rate your overall satisfaction with our speed?");
		surveyDao.save(survey3);

		Answer answer1 = new Answer();
		answer1.setFeedback("Good service");
		answer1.setSurvey(survey1);
		answer1.setScore(7);
		answerDao.save(answer1);

		Answer answer2 = new Answer();
		answer2.setFeedback("It was very slow");
		answer2.setSurvey(survey3);
		answer2.setScore(7);
		answerDao.save(answer2);
	}

}

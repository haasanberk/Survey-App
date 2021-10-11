package com.example.surveyApp;

import com.example.surveyApp.dao.AnswerDao;
import com.example.surveyApp.dao.SurveyDao;
import com.example.surveyApp.dao.TopicDao;
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
	}

}

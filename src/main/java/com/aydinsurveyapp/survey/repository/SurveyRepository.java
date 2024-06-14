package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    Survey findBySurveyId(Integer surveyId);

}

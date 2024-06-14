package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.QuestionValue;

@Repository 
public interface QuestionValueRepository  extends JpaRepository <QuestionValue, Integer>{
}

package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.QuestionType;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer>{
}

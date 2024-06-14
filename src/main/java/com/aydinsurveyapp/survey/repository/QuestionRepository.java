package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

    Question findByQuestionId(Integer questionId);
}

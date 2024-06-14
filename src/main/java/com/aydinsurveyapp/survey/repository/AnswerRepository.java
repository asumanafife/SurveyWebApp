package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.Answer;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Integer> {

    Answer findByAsnwerId(Integer answerId);
   // Answer findByAnswerIdAndAnswerValue(Integer answerId, String val);

    //@Query("SELECT a FROM Answer a WHERE a.answerID=?1 AND a.answerValue=?2")
   // Answer sorgula(Integer answerId, String answerValue);
}

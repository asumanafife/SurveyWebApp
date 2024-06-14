package com.aydinsurveyapp.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.SurveyParticipant;

@Repository
public interface SurveyParticipantRepository extends JpaRepository<SurveyParticipant, Integer>{

    List<SurveyParticipant> findBySurveyParticipantId(Integer id);
    SurveyParticipant getBySurveyParticipantId(Integer id);
}

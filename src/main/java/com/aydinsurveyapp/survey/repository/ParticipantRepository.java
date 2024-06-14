package com.aydinsurveyapp.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aydinsurveyapp.survey.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

    Participant findByParticipantId(Integer participantId);
}

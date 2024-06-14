package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.SurveyParticipantDTO;
import com.aydinsurveyapp.survey.dto.SurveyParticipantEditDTO;

public interface SurveyParticipantService {

    SurveyParticipantDTO create(SurveyParticipantEditDTO surveyParticipantEditDTO);

    SurveyParticipantDTO update(SurveyParticipantEditDTO surveyParticipantEditDTO, Integer surveyParticipantId);

    void delete(Integer surveyParticipantId);

    SurveyParticipantDTO getById(Integer surveyParticipantId);

    List<SurveyParticipantDTO> findAll();
}

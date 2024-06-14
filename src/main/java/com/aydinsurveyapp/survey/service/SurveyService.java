package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.SurveyDTO;
import com.aydinsurveyapp.survey.dto.SurveyEditDTO;

public interface SurveyService {

    SurveyDTO create(SurveyEditDTO surveyEditDTO);

    SurveyDTO update(SurveyEditDTO surveyEditDTO, Integer surveyId);

    void delete(Integer surveyId);

    SurveyDTO getById(Integer surveyId);

    List<SurveyDTO> findAll();
}

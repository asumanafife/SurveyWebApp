package com.aydinsurveyapp.survey.service;

import com.aydinsurveyapp.survey.dto.QuestionValueDTO;
import com.aydinsurveyapp.survey.dto.QuestionValueEditDTO;

import java.util.List;

public interface QuestionValueService {

    QuestionValueDTO create(QuestionValueEditDTO questionValueEditDTO);

    QuestionValueDTO update(QuestionValueEditDTO questionValueEditDTO, Integer valueId);

    void delete(Integer valueId);

    QuestionValueDTO getById(Integer valueId);

    List<QuestionValueDTO> findAll();
}

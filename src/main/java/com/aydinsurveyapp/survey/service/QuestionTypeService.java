package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.QuestionTypeDTO;
import com.aydinsurveyapp.survey.dto.QuestionTypeEditDTO;

public interface QuestionTypeService {

    QuestionTypeDTO create(QuestionTypeEditDTO questionTypeEditDTO);

    QuestionTypeDTO update(QuestionTypeEditDTO questionTypeEditDTO, Integer typeId);

    void delete(Integer typeId);

    QuestionTypeDTO getById(Integer typeId);

    List<QuestionTypeDTO> findAll();

}

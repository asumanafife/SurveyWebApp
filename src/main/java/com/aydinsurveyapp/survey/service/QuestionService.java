package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.QuestionDTO;
import com.aydinsurveyapp.survey.dto.QuestionEditDTO;


public interface QuestionService {

    QuestionDTO create(QuestionEditDTO userEditDTO);

    QuestionDTO update(QuestionEditDTO userEditDTO, Integer userId);

    void delete(Integer userId);

    QuestionDTO getById(Integer userId);

    List<QuestionDTO> findAll();

}

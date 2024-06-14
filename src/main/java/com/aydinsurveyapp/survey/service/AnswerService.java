package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.AnswerDTO;
import com.aydinsurveyapp.survey.dto.AnswerEditDTO;

public interface AnswerService {

    
    AnswerDTO create(AnswerEditDTO userEditDTO);

    AnswerDTO update(AnswerEditDTO userEditDTO, Integer userId);

    void delete(Integer userId);

    AnswerDTO getById(Integer userId);

    List<AnswerDTO> findAll();
}

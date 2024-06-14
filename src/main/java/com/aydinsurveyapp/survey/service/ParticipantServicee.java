package com.aydinsurveyapp.survey.service;

import java.util.List;

import com.aydinsurveyapp.survey.dto.ParticipantDTO;
import com.aydinsurveyapp.survey.dto.ParticipantEditDTO;

public interface ParticipantServicee {

    ParticipantDTO create(ParticipantEditDTO participantEditDTO);

    ParticipantDTO update(ParticipantEditDTO participantEditDTO, Integer participantId);

    void delete(Integer participantId);

    ParticipantDTO getById(Integer participantId);

    List<ParticipantDTO> findAll();
}

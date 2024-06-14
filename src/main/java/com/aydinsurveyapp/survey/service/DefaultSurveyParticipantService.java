package com.aydinsurveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aydinsurveyapp.survey.dto.ParticipantDTO;
import com.aydinsurveyapp.survey.dto.SurveyDTO;
import com.aydinsurveyapp.survey.dto.SurveyParticipantDTO;
import com.aydinsurveyapp.survey.dto.SurveyParticipantEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.Participant;
import com.aydinsurveyapp.survey.model.Survey;
import com.aydinsurveyapp.survey.model.SurveyParticipant;
import com.aydinsurveyapp.survey.repository.SurveyParticipantRepository;

@Service
public class DefaultSurveyParticipantService implements SurveyParticipantService {

    private final SurveyParticipantRepository surveyParticipantRepository;

    public DefaultSurveyParticipantService(SurveyParticipantRepository surveyParticipantRepository) {
        this.surveyParticipantRepository = surveyParticipantRepository;
    }

    @Override
    public SurveyParticipantDTO create(SurveyParticipantEditDTO surveyParticipantEditDTO) {
        if (surveyParticipantEditDTO == null || surveyParticipantEditDTO.getSurveyId() == null || surveyParticipantEditDTO.getParticipantId() == null) {
            throw new BadRequestException("Survey ID and Participant ID must be provided");
        }

        SurveyParticipant surveyParticipant = surveyParticipantEditDTOToSurveyParticipant(surveyParticipantEditDTO);
        surveyParticipant = surveyParticipantRepository.save(surveyParticipant);
        return surveyParticipantToSurveyParticipantDTO(surveyParticipant);
    }

    @Override
    public SurveyParticipantDTO update(SurveyParticipantEditDTO surveyParticipantEditDTO, Integer surveyParticipantId) {
        SurveyParticipant surveyParticipant = surveyParticipantRepository.getBySurveyParticipantId(surveyParticipantId);
        if (surveyParticipant == null) {
            throw new NotFoundException("Survey participant not found");
        }

        surveyParticipant.setSurvey(Survey.builder().surveyId(surveyParticipantEditDTO.getSurveyId()).build());
        surveyParticipant.setParticipant(Participant.builder().participantId(surveyParticipantEditDTO.getParticipantId()).build());
        surveyParticipant.setDate(surveyParticipantEditDTO.getDate());
        surveyParticipantRepository.save(surveyParticipant);
        return surveyParticipantToSurveyParticipantDTO(surveyParticipant);
    }

    @Override
    public void delete(Integer surveyParticipantId) {
        SurveyParticipant surveyParticipant = surveyParticipantRepository.getBySurveyParticipantId(surveyParticipantId);
        if (surveyParticipant == null) {
            throw new NotFoundException("Survey participant not found");
        }
        surveyParticipantRepository.deleteById(surveyParticipantId);
    }

    @Override
    public SurveyParticipantDTO getById(Integer surveyParticipantId) {
        SurveyParticipant surveyParticipant = surveyParticipantRepository.getBySurveyParticipantId(surveyParticipantId);
        if (surveyParticipant == null) {
            throw new NotFoundException("Survey participant not found");
        }
        return surveyParticipantToSurveyParticipantDTO(surveyParticipant);
    }

    @Override
    public List<SurveyParticipantDTO> findAll() {
        List<SurveyParticipant> surveyParticipants = surveyParticipantRepository.findAll();
        List<SurveyParticipantDTO> surveyParticipantDTOs = new ArrayList<>();

        for (SurveyParticipant surveyParticipant : surveyParticipants) {
            surveyParticipantDTOs.add(surveyParticipantToSurveyParticipantDTO(surveyParticipant));
        }
        return surveyParticipantDTOs;
    }

    private SurveyParticipant surveyParticipantEditDTOToSurveyParticipant(SurveyParticipantEditDTO surveyParticipantEditDTO) {
        return SurveyParticipant.builder()
                .survey(Survey.builder().surveyId(surveyParticipantEditDTO.getSurveyId()).build())
                .participant(Participant.builder().participantId(surveyParticipantEditDTO.getParticipantId()).build())
                .date(surveyParticipantEditDTO.getDate())
                .build();
    }

    private SurveyParticipantDTO surveyParticipantToSurveyParticipantDTO(SurveyParticipant surveyParticipant) {
        return SurveyParticipantDTO.builder()
                .id(surveyParticipant.getSurveyParticipantId())
                .survey(
                    SurveyDTO.builder()
                    .surveyId(surveyParticipant.getSurvey().getSurveyId())
                    .surveyTitle(surveyParticipant.getSurvey().getSurveyTitle())
                    .description(surveyParticipant.getSurvey().getDescription())
                    .endDate(surveyParticipant.getSurvey().getEndDate())
                    .startDate(surveyParticipant.getSurvey().getStartDate()).build()
                    ).date(surveyParticipant.getDate())
                .participant(
                        ParticipantDTO.builder()
                        .participantId(surveyParticipant.getParticipant().getParticipantId()).build())
                        .build();
    }
}

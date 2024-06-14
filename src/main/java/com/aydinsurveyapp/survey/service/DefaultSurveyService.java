package com.aydinsurveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aydinsurveyapp.survey.dto.SurveyDTO;
import com.aydinsurveyapp.survey.dto.SurveyEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.Survey;
import com.aydinsurveyapp.survey.repository.SurveyRepository;

@Service
public class DefaultSurveyService implements SurveyService {

    private final SurveyRepository surveyRepository;

    public DefaultSurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public SurveyDTO create(SurveyEditDTO surveyEditDTO) {
        if (surveyEditDTO == null || surveyEditDTO.getSurveyTitle() == null || surveyEditDTO.getStartDate() == null || surveyEditDTO.getEndDate() == null) {
            throw new BadRequestException("Survey title, start date, and end date must be provided");
        }

        Survey survey = surveyEditDTOtoSurvey(surveyEditDTO);
        survey = surveyRepository.save(survey);
        return surveyToSurveyDTO(survey);
    }

    @Override
    public SurveyDTO update(SurveyEditDTO surveyEditDTO, Integer surveyId) {
        Survey survey = surveyRepository.findBySurveyId(surveyId);
        if (survey == null) {
            throw new NotFoundException("Survey not found");
        }

        survey.setSurveyTitle(surveyEditDTO.getSurveyTitle());
        survey.setDescription(surveyEditDTO.getDescription());
        survey.setStartDate(surveyEditDTO.getStartDate());
        survey.setEndDate(surveyEditDTO.getEndDate());

        surveyRepository.save(survey);
        return surveyToSurveyDTO(survey);
    }

    @Override
    public void delete(Integer surveyId) {
        Survey survey = surveyRepository.findBySurveyId(surveyId);
        if (survey == null) {
            throw new NotFoundException("Survey not found");
        }
        surveyRepository.deleteById(surveyId);
    }

    @Override
    public SurveyDTO getById(Integer surveyId) {
        Survey survey = surveyRepository.findBySurveyId(surveyId);
        if (survey == null) {
            throw new NotFoundException("Survey not found");
        }
        return surveyToSurveyDTO(survey);
    }

    @Override
    public List<SurveyDTO> findAll() {
        List<Survey> surveys = surveyRepository.findAll();
        List<SurveyDTO> surveyDTOs = new ArrayList<>();

        for (Survey survey : surveys) {
            surveyDTOs.add(surveyToSurveyDTO(survey));
        }
        return surveyDTOs;
    }

    private SurveyDTO surveyToSurveyDTO(Survey survey) {
        return SurveyDTO.builder()
                .surveyId(survey.getSurveyId())
                .surveyTitle(survey.getSurveyTitle())
                .description(survey.getDescription())
                .startDate(survey.getStartDate())
                .endDate(survey.getEndDate())
                .build();
    }

    private Survey surveyEditDTOtoSurvey(SurveyEditDTO surveyEditDTO) {
        return Survey.builder()
                .surveyTitle(surveyEditDTO.getSurveyTitle())
                .description(surveyEditDTO.getDescription())
                .startDate(surveyEditDTO.getStartDate())
                .endDate(surveyEditDTO.getEndDate())
                .build();
    }
}

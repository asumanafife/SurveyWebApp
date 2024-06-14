package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.SurveyParticipantDTO;
import com.aydinsurveyapp.survey.dto.SurveyParticipantEditDTO;
import com.aydinsurveyapp.survey.service.SurveyParticipantService;
import java.util.List;

@RestController
@RequestMapping("/survey-participant")
public class SurveyParticipantController {

    private SurveyParticipantService surveyParticipantService;

    public SurveyParticipantController(SurveyParticipantService surveyParticipantService) {
        this.surveyParticipantService = surveyParticipantService;
    }

    @GetMapping("/{surveyParticipantId}")
    public ResponseEntity<SurveyParticipantDTO> getSurveyParticipant(@PathVariable Integer surveyParticipantId) {
        SurveyParticipantDTO surveyParticipantDTO = surveyParticipantService.getById(surveyParticipantId);
        return new ResponseEntity<SurveyParticipantDTO>(surveyParticipantDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<SurveyParticipantDTO>> getAllSurveyParticipants() {
        List<SurveyParticipantDTO> surveyParticipantDTOs = surveyParticipantService.findAll();
        return new ResponseEntity<>(surveyParticipantDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<SurveyParticipantDTO> createSurveyParticipant(@RequestBody SurveyParticipantEditDTO surveyParticipantEditDTO) {
        SurveyParticipantDTO surveyParticipantDTO = surveyParticipantService.create(surveyParticipantEditDTO);
        return new ResponseEntity<>(surveyParticipantDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{surveyParticipantId}")
    public ResponseEntity<SurveyParticipantDTO> updateSurveyParticipant(
            @RequestBody SurveyParticipantEditDTO surveyParticipantEditDTO, @PathVariable Integer surveyParticipantId) {
        SurveyParticipantDTO surveyParticipantDTO = surveyParticipantService.update(surveyParticipantEditDTO, surveyParticipantId);
        return new ResponseEntity<>(surveyParticipantDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{surveyParticipantId}")
    public ResponseEntity<Boolean> deleteSurveyParticipant(@PathVariable Integer surveyParticipantId) {
        surveyParticipantService.delete(surveyParticipantId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

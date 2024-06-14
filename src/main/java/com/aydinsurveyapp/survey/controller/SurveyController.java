package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.SurveyDTO;
import com.aydinsurveyapp.survey.dto.SurveyEditDTO;
import com.aydinsurveyapp.survey.service.SurveyService;
import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<SurveyDTO> getSurvey(@PathVariable Integer surveyId) {
        SurveyDTO surveyDTO = surveyService.getById(surveyId);
        return new ResponseEntity<SurveyDTO>(surveyDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<SurveyDTO>> getAllSurveys() {
        List<SurveyDTO> surveyDTOs = surveyService.findAll();
        return new ResponseEntity<>(surveyDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<SurveyDTO> createSurvey(@RequestBody SurveyEditDTO surveyEditDTO) {
        SurveyDTO surveyDTO = surveyService.create(surveyEditDTO);
        return new ResponseEntity<>(surveyDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{surveyId}")
    public ResponseEntity<SurveyDTO> updateSurvey(
            @RequestBody SurveyEditDTO surveyEditDTO, @PathVariable Integer surveyId) {
        SurveyDTO surveyDTO = surveyService.update(surveyEditDTO, surveyId);
        return new ResponseEntity<>(surveyDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{surveyId}")
    public ResponseEntity<Boolean> deleteSurvey(@PathVariable Integer surveyId) {
        surveyService.delete(surveyId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

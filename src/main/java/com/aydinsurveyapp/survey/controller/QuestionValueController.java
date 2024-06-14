package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.QuestionValueDTO;
import com.aydinsurveyapp.survey.dto.QuestionValueEditDTO;
import com.aydinsurveyapp.survey.service.QuestionValueService;
import java.util.List;

@RestController
@RequestMapping("/question-value")
public class QuestionValueController {

    private  QuestionValueService questionValueService;

    public QuestionValueController(QuestionValueService questionValueService) {
        this.questionValueService = questionValueService;
    }

    @GetMapping("/{valueId}")
    public ResponseEntity<QuestionValueDTO> getQuestionValue(@PathVariable Integer valueId) {
        QuestionValueDTO questionValueDTO = questionValueService.getById(valueId);
        return new ResponseEntity<QuestionValueDTO>(questionValueDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<QuestionValueDTO>> getAllQuestionValues() {
        List<QuestionValueDTO> questionValueDTOs = questionValueService.findAll();
        return new ResponseEntity<>(questionValueDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<QuestionValueDTO> createQuestionValue(@RequestBody QuestionValueEditDTO questionValueEditDTO) {
        QuestionValueDTO questionValueDTO = questionValueService.create(questionValueEditDTO);
        return new ResponseEntity<>(questionValueDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{valueId}")
    public ResponseEntity<QuestionValueDTO> updateQuestionValue(
            @RequestBody QuestionValueEditDTO questionValueEditDTO, @PathVariable Integer valueId) {
        QuestionValueDTO questionValueDTO = questionValueService.update(questionValueEditDTO, valueId);
        return new ResponseEntity<>(questionValueDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{valueId}")
    public ResponseEntity<Boolean> deleteQuestionValue(@PathVariable Integer valueId) {
        questionValueService.delete(valueId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

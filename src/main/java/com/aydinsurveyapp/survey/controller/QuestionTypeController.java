package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.QuestionTypeDTO;
import com.aydinsurveyapp.survey.dto.QuestionTypeEditDTO;
import com.aydinsurveyapp.survey.service.QuestionTypeService;
import java.util.List;

@RestController
@RequestMapping("/question-type")
public class QuestionTypeController {

    private final QuestionTypeService questionTypeService;

    public QuestionTypeController(QuestionTypeService questionTypeService) {
        this.questionTypeService = questionTypeService;
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<QuestionTypeDTO> getQuestionType(@PathVariable Integer typeId) {
        QuestionTypeDTO questionTypeDTO = questionTypeService.getById(typeId);
        return new ResponseEntity<QuestionTypeDTO>(questionTypeDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<QuestionTypeDTO>> getAllQuestionTypes() {
        List<QuestionTypeDTO> questionTypeDTOs = questionTypeService.findAll();
        return new ResponseEntity<>(questionTypeDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<QuestionTypeDTO> createQuestionType(@RequestBody QuestionTypeEditDTO questionTypeEditDTO) {
        QuestionTypeDTO questionTypeDTO = questionTypeService.create(questionTypeEditDTO);
        return new ResponseEntity<>(questionTypeDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{typeId}")
    public ResponseEntity<QuestionTypeDTO> updateQuestionType(
            @RequestBody QuestionTypeEditDTO questionTypeEditDTO, @PathVariable Integer typeId) {
        QuestionTypeDTO questionTypeDTO = questionTypeService.update(questionTypeEditDTO, typeId);
        return new ResponseEntity<>(questionTypeDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{typeId}")
    public ResponseEntity<Boolean> deleteQuestionType(@PathVariable Integer typeId) {
        questionTypeService.delete(typeId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

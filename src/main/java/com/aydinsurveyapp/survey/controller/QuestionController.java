package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.QuestionDTO;
import com.aydinsurveyapp.survey.dto.QuestionEditDTO;
import com.aydinsurveyapp.survey.service.QuestionService;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable Integer questionId) {
        QuestionDTO questionDTO = questionService.getById(questionId);
        return new ResponseEntity<QuestionDTO>(questionDTO, HttpStatusCode.valueOf(200));
    }
    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        List<QuestionDTO> questionDTOs = questionService.findAll();
        return new ResponseEntity<>(questionDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionEditDTO questionEditDTO) {
        QuestionDTO questionDTO = questionService.create(questionEditDTO);
        return new ResponseEntity<>(questionDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<QuestionDTO> updateQuestion(
            @RequestBody QuestionEditDTO questionEditDTO, @PathVariable Integer questionId) {
        QuestionDTO questionDTO = questionService.update(questionEditDTO, questionId);
        return new ResponseEntity<>(questionDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable Integer questionId) {
        questionService.delete(questionId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

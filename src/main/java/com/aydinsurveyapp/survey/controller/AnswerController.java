package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.AnswerDTO;
import com.aydinsurveyapp.survey.dto.AnswerEditDTO;
import com.aydinsurveyapp.survey.service.AnswerService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<AnswerDTO> getAnswer(@PathVariable Integer answerId) {
        AnswerDTO answerDTO = answerService.getById(answerId);
        return new ResponseEntity<AnswerDTO>(answerDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswers() {
        List<AnswerDTO> answerDTOs = answerService.findAll();
        return new ResponseEntity<>(answerDTOs, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@RequestBody @Valid AnswerEditDTO answerEditDTO) {
        AnswerDTO answerDTO = answerService.create(answerEditDTO);
        return new ResponseEntity<>(answerDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<AnswerDTO> updateAnswer(
            @RequestBody AnswerEditDTO answerEditDTO, @PathVariable Integer answerId) {
        AnswerDTO answerDTO = answerService.update(answerEditDTO, answerId);
        return new ResponseEntity<>(answerDTO, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Boolean> deleteAnswer(@PathVariable Integer answerId) {
        answerService.delete(answerId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}

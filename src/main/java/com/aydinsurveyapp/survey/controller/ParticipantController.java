package com.aydinsurveyapp.survey.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aydinsurveyapp.survey.dto.ParticipantDTO;
import com.aydinsurveyapp.survey.dto.ParticipantEditDTO;
import com.aydinsurveyapp.survey.service.ParticipantServicee;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    private final ParticipantServicee participantService;

    public ParticipantController(ParticipantServicee participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/{participantId}")
    public ResponseEntity<ParticipantDTO> getParticipant(@PathVariable Integer participantId) {
        ParticipantDTO participantDTO = participantService.getById(participantId);
        return new ResponseEntity<ParticipantDTO>(participantDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDTO>> getAllParticipants() {
        List<ParticipantDTO> participantDTOs = participantService.findAll();
        return new ResponseEntity<>(participantDTOs, HttpStatusCode.valueOf(200));

    }

    @PostMapping
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantEditDTO participantEditDTO) {
        ParticipantDTO participantDTO = participantService.create(participantEditDTO);
        return new ResponseEntity<>(participantDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{participantId}")
    public ResponseEntity<ParticipantDTO> updateParticipant(
            @RequestBody ParticipantEditDTO participantEditDTO, @PathVariable Integer participantId) {
        ParticipantDTO participantDTO = participantService.update(participantEditDTO, participantId);
        return new ResponseEntity<>(participantDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{participantId}")
    public ResponseEntity<Boolean> deleteParticipant(@PathVariable Integer participantId) {
        participantService.delete(participantId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    
    }
}

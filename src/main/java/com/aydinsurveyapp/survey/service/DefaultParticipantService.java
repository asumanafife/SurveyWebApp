package com.aydinsurveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aydinsurveyapp.survey.dto.ParticipantDTO;
import com.aydinsurveyapp.survey.dto.ParticipantEditDTO;
import com.aydinsurveyapp.survey.model.Participant;
import com.aydinsurveyapp.survey.repository.ParticipantRepository;

@Service
public class DefaultParticipantService implements ParticipantServicee {

    private ParticipantRepository participantRepository;

    public DefaultParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public ParticipantDTO create(ParticipantEditDTO participantEditDTO) {
        Participant participant = participantEditDTOtoParticipant(participantEditDTO);
        participant = participantRepository.save(participant);
        return participantToParticipantDTO(participant);
    }

    @Override
    public ParticipantDTO update(ParticipantEditDTO participantEditDTO, Integer participantId) {
        Participant participant = participantRepository.findByParticipantId(participantId);
        participant.setFirstName(participantEditDTO.getFirstName());
        participant.setLastName(participantEditDTO.getLastName());
        participant.setEMail(participantEditDTO.getEmail());
        participantRepository.save(participant);
        return participantToParticipantDTO(participant);
    }

    @Override
    public void delete(Integer participantId) {
        participantRepository.deleteById(participantId);
    }

    @Override
    public ParticipantDTO getById(Integer participantId) {
        Participant participant = participantRepository.findByParticipantId(participantId);
        return participantToParticipantDTO(participant);
    }

    @Override
    public List<ParticipantDTO> findAll() {
        List<Participant> participants = participantRepository.findAll();
        List<ParticipantDTO> participantDTOs = new ArrayList<>();

        for (Participant participant : participants) {
            participantDTOs.add(participantToParticipantDTO(participant));
        }
        return participantDTOs;
    }

    private Participant participantEditDTOtoParticipant(ParticipantEditDTO participantEditDTO) {
        return Participant.builder()
                .firstName(participantEditDTO.getFirstName())
                .lastName(participantEditDTO.getLastName())
                .eMail(participantEditDTO.getEmail())
                .build();
    }

    private ParticipantDTO participantToParticipantDTO(Participant participant) {
        return ParticipantDTO.builder()
                .participantId(participant.getParticipantId())
                .firstName(participant.getFirstName())
                .lastName(participant.getLastName())
                .eMail(participant.getEMail())
                .build();
    }
}

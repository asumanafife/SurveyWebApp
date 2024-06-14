package com.aydinsurveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.aydinsurveyapp.survey.model.Answer;
import com.aydinsurveyapp.survey.model.Question;
import com.aydinsurveyapp.survey.repository.AnswerRepository;
import com.aydinsurveyapp.survey.dto.AnswerDTO;
import com.aydinsurveyapp.survey.dto.AnswerEditDTO;
import com.aydinsurveyapp.survey.exception.NotFoundException;


@Service
public class DefaultAnswerService implements AnswerService{

    private AnswerRepository answerRepository;

    public DefaultAnswerService(AnswerRepository answerRepository){
        this.answerRepository= answerRepository;
    }
    @Override
    public AnswerDTO create(AnswerEditDTO answerEditDTO) { 
        Answer answer = answerEditDTOtoAnswer(answerEditDTO);
        answer = answerRepository.save(answer);
        return answerToAnswerDTO(answer);
    }
   
     @Override
    public AnswerDTO update(AnswerEditDTO answerEditDTO, Integer answerId) {
        Answer answer = answerRepository.findByAsnwerId(answerId);
        if(answer == null) {
            throw new NotFoundException("Answer not found");
        }
        answer.setAnswerValue(answerEditDTO.getAnswerValue());
        answerRepository.save(answer);
        return answerToAnswerDTO(answer);
    }

    @Override
    public void delete(Integer AnswerId) {
        answerRepository.deleteById(AnswerId);
    }
    @Override
    public AnswerDTO getById(Integer answerId) {
        Answer answer = answerRepository.findByAsnwerId(answerId);
        if(answer == null) {
            throw new NotFoundException("Answer not found");
        }
        return answerToAnswerDTO(answer);
    }
    @Override
    public List<AnswerDTO> findAll() {
        List<Answer> answers = answerRepository.findAll();
        List<AnswerDTO> answerDTOs = new ArrayList<>();

        for(Answer answer: answers){
            answerDTOs.add(answerToAnswerDTO(answer));
        }
        return answerDTOs;
    }
    private Answer answerEditDTOtoAnswer(AnswerEditDTO answerEditDTO) {
        Question question = Question.builder().questionId(answerEditDTO.getQuestionId()).build();
        return Answer.builder()
                .answerValue(answerEditDTO.getAnswerValue())
                .question(question)
                .build();
    }

    private AnswerDTO answerToAnswerDTO(Answer answer) {
        return AnswerDTO.builder()
                .answerValue(answer.getAnswerValue())
                .answerId(answer.getAsnwerId())
                .participantId(answer.getParticipant().getId()) // Doğru metod adını ve alan adını kullanın
                .questionId(answer.getQuestion().getId()) // Aynı şekilde, doğru metod adını ve alan adını kullanın
                .build();
    }
}
    

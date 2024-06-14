package com.aydinsurveyapp.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aydinsurveyapp.survey.dto.QuestionDTO;
import com.aydinsurveyapp.survey.dto.QuestionEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.Question;
import com.aydinsurveyapp.survey.model.QuestionType;
import com.aydinsurveyapp.survey.model.QuestionValue;
import com.aydinsurveyapp.survey.model.Survey;
import com.aydinsurveyapp.survey.model.User;
import com.aydinsurveyapp.survey.repository.QuestionRepository;

@Service
public class DefultQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public DefultQuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDTO create(QuestionEditDTO questionEditDTO) { 
        if (questionEditDTO == null || questionEditDTO.getQuestionText() == null || questionEditDTO.getQuestionTypeId() == null) {
            throw new BadRequestException("Question text and type must be provided");
        }

        Question question = questionEditDTOtoQuestion(questionEditDTO);
        question = questionRepository.save(question);
        return questionToQuestionDTO(question);
    }

    @Override
    public QuestionDTO update(QuestionEditDTO questionEditDTO, Integer questionId) {
        Question question = questionRepository.findByQuestionId(questionId);
        if (question == null) {
            throw new NotFoundException("Question not found");
        }

       
        question.setQuestionText(questionEditDTO.getQuestionText());
        question.setQuestionType(QuestionType.builder().typeId(questionEditDTO.getQuestionTypeId()).build());

        List<QuestionValue> questionValues = new ArrayList<>();
        for(String s: questionEditDTO.getQuestionValues()){
            questionValues.add(QuestionValue.builder().value(s).build());
        }
        question.setQuestionValue(questionValues);

        question.setRequired(questionEditDTO.isRequired());
        question.setSurvey(Survey.builder().surveyId(questionEditDTO.getSurveyId()).build());
        question.setUser(User.builder().userId(questionEditDTO.getUserId()).build());

        questionRepository.save(question);
        return questionToQuestionDTO(question);
    }

    @Override
    public void delete(Integer questionId) {
        Question question = questionRepository.findByQuestionId(questionId);
        if (question == null) {
            throw new NotFoundException("Question not found");
        }
        questionRepository.deleteById(questionId);
    }

    @Override
    public QuestionDTO getById(Integer questionId) {
        Question question = questionRepository.findByQuestionId(questionId);
        if (question == null) {
            throw new NotFoundException("Question not found");
        }
        return questionToQuestionDTO(question);
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDTO> questionDTOs = new ArrayList<>();

        for(Question question: questions){
            questionDTOs.add(questionToQuestionDTO(question));
        }
        return questionDTOs;
    }

    private Question questionEditDTOtoQuestion(QuestionEditDTO questionEditDTO) {
        Question question = new Question();
       
        question.setQuestionText(questionEditDTO.getQuestionText());
        question.setQuestionType(QuestionType.builder().typeId(questionEditDTO.getQuestionTypeId()).build());

        List<QuestionValue> questionValues = new ArrayList<>();
        for(String s: questionEditDTO.getQuestionValues()){
            questionValues.add(QuestionValue.builder().value(s).build());
        }
        question.setQuestionValue(questionValues);

        question.setRequired(questionEditDTO.isRequired());
        question.setSurvey(Survey.builder().surveyId(questionEditDTO.getSurveyId()).build());
        question.setUser(User.builder().userId(questionEditDTO.getUserId()).build());
        return question;
    }

    private QuestionDTO questionToQuestionDTO(Question question) {
        QuestionDTO questionDTO =  new QuestionDTO();
        questionDTO.setLength(question.getLenght());
        questionDTO.setQuestionText(question.getQuestionText());
        questionDTO.setQuestionTypeId(question.getQuestionType().getTypeId());

        List<String> questionValues = new ArrayList<>();
        for (QuestionValue value: question.getQuestionValue()){
            questionValues.add(value.getValue());
        }
        questionDTO.setQuestionValues(questionValues);

        questionDTO.setRequired(question.isRequired());
        questionDTO.setSurveyId(question.getSurvey().getSurveyId());
        questionDTO.setUserId(question.getUser().getUserId());
        return questionDTO;
    }
}

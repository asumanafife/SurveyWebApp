package com.aydinsurveyapp.survey.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aydinsurveyapp.survey.dto.QuestionTypeDTO;
import com.aydinsurveyapp.survey.dto.QuestionTypeEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.QuestionType;
import com.aydinsurveyapp.survey.repository.QuestionTypeRepository;

@Service
public class DefaultQuestionTypeService implements QuestionTypeService {

    private final QuestionTypeRepository questionTypeRepository;

    public DefaultQuestionTypeService(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public QuestionTypeDTO create(QuestionTypeEditDTO questionTypeEditDTO) {
        if (questionTypeEditDTO == null) {
            throw new BadRequestException("Question type data cannot be null");
        }

        QuestionType questionType = new QuestionType();
        BeanUtils.copyProperties(questionTypeEditDTO, questionType);

        QuestionType savedQuestionType = questionTypeRepository.save(questionType);
        return convertToDTO(savedQuestionType);
    }

    @Override
    public QuestionTypeDTO update(QuestionTypeEditDTO questionTypeEditDTO, Integer typeId) {
        QuestionType existingQuestionType = questionTypeRepository.findById(typeId)
                .orElseThrow(() -> new NotFoundException("Question type not found with id: " + typeId));

        BeanUtils.copyProperties(questionTypeEditDTO, existingQuestionType);

        QuestionType updatedQuestionType = questionTypeRepository.save(existingQuestionType);
        return convertToDTO(updatedQuestionType);
    }

    @Override
    public void delete(Integer typeId) {
        questionTypeRepository.findById(typeId)
                .orElseThrow(() -> new NotFoundException("Question type not found with id: " + typeId));
        questionTypeRepository.deleteById(typeId);
    }

    @Override
    public QuestionTypeDTO getById(Integer typeId) {
        QuestionType questionType = questionTypeRepository.findById(typeId)
                .orElseThrow(() -> new NotFoundException("Question type not found with id: " + typeId));
        return convertToDTO(questionType);
    }

    @Override
    public List<QuestionTypeDTO> findAll() {
        List<QuestionType> questionTypes = questionTypeRepository.findAll();
        return questionTypes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private QuestionTypeDTO convertToDTO(QuestionType questionType) {
        QuestionTypeDTO questionTypeDTO = new QuestionTypeDTO();
        BeanUtils.copyProperties(questionType, questionTypeDTO);
        return questionTypeDTO;
    }
}

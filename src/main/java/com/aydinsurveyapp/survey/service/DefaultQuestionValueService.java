package com.aydinsurveyapp.survey.service;

import com.aydinsurveyapp.survey.dto.QuestionValueDTO;
import com.aydinsurveyapp.survey.dto.QuestionValueEditDTO;
import com.aydinsurveyapp.survey.exception.BadRequestException;
import com.aydinsurveyapp.survey.exception.NotFoundException;
import com.aydinsurveyapp.survey.model.QuestionValue;
import com.aydinsurveyapp.survey.repository.QuestionValueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultQuestionValueService implements QuestionValueService {

    private final QuestionValueRepository questionValueRepository;

    public DefaultQuestionValueService(QuestionValueRepository questionValueRepository) {
        this.questionValueRepository = questionValueRepository;
    }

    @Override
    @Transactional
    public QuestionValueDTO create(QuestionValueEditDTO questionValueEditDTO) {
        if (questionValueEditDTO == null) {
            throw new BadRequestException("Question value data cannot be null");
        }

        QuestionValue questionValue = new QuestionValue();
        BeanUtils.copyProperties(questionValueEditDTO, questionValue);

        QuestionValue savedQuestionValue = questionValueRepository.save(questionValue);
        return convertToDTO(savedQuestionValue);
    }

    @Override
    @Transactional
    public QuestionValueDTO update(QuestionValueEditDTO questionValueEditDTO, Integer valueId) {
        QuestionValue existingQuestionValue = questionValueRepository.findById(valueId)
                .orElseThrow(() -> new NotFoundException("Question value not found with id: " + valueId));

        BeanUtils.copyProperties(questionValueEditDTO, existingQuestionValue);

        QuestionValue updatedQuestionValue = questionValueRepository.save(existingQuestionValue);
        return convertToDTO(updatedQuestionValue);
    }

    @Override
    @Transactional
    public void delete(Integer valueId) {
        questionValueRepository.findById(valueId).orElseThrow(() -> new NotFoundException("Question value not found with id: " + valueId));
        questionValueRepository.deleteById(valueId);
    }

    @Override
    @Transactional(readOnly = true)
    public QuestionValueDTO getById(Integer valueId) {
        QuestionValue questionValue = questionValueRepository.findById(valueId)
                .orElseThrow(() -> new NotFoundException("Question value not found with id: " + valueId));
        return convertToDTO(questionValue);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionValueDTO> findAll() {
        List<QuestionValue> questionValues = questionValueRepository.findAll();
        return questionValues.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private QuestionValueDTO convertToDTO(QuestionValue questionValue) {
        QuestionValueDTO questionValueDTO = new QuestionValueDTO();
        BeanUtils.copyProperties(questionValue, questionValueDTO);
        return questionValueDTO;
    }
}

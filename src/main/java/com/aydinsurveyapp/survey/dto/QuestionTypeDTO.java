package com.aydinsurveyapp.survey.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class QuestionTypeDTO {
    
    private Integer typeId;
    private String name;
    private List<QuestionDTO> questions;
}

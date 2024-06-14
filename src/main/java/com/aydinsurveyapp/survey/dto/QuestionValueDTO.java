package com.aydinsurveyapp.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuestionValueDTO {

    private Integer valueId;
    private QuestionDTO question; 
    private String value;

   
}

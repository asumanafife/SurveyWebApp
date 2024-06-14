package com.aydinsurveyapp.survey.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
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

public class QuestionEditDTO {
   

    @NotNull(message = "Survey Id is required")
    private Integer surveyId;


    @NotNull(message = "Question Text is required")
    private String questionText;

  
    @NotNull(message = "Question Type Id is required")
    private Integer questionTypeId;

  
    @NotNull(message = "User Id is required")
    private Integer userId;


 
    private Integer length;

  

    private boolean required;

    
    private List<String> questionValues;
}

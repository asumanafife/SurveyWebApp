package com.aydinsurveyapp.survey.dto;

import java.util.List;

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

public class QuestionDTO {
   

   
    private Integer questionId;

    
    private Integer surveyId;


  
    private String questionText;

  
   
    private Integer questionTypeId;

  
    private Integer userId;


 
    private Integer length;

  

    private boolean required;

    
    private List<String> questionValues;
}

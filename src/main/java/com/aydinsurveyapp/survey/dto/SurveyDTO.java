package com.aydinsurveyapp.survey.dto;

import java.util.Date;


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
public class SurveyDTO {


   
        private Integer surveyId;
        private String surveyTitle;
        private String description;
        private Date startDate;
        private Date endDate;
        private UserDTO user;
      
    
        
    }


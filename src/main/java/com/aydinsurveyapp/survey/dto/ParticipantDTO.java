package com.aydinsurveyapp.survey.dto;

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
public class ParticipantDTO {

  
        private Integer participantId;
        private String firstName;
        private String lastName;
        private String eMail;
        private String answers;
        private String surveyParticipants;
    
}

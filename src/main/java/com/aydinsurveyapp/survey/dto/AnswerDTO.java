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
public class AnswerDTO {

    private Integer answerId;
    private Integer questionId;
    private String answerValue;
    private Integer surveyParticipantId;
    private Integer participantId;
}

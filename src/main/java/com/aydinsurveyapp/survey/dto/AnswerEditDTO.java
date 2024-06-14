package com.aydinsurveyapp.survey.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AnswerEditDTO {

    @NotNull(message = "Question field is required")
    private Integer questionId;

    @NotBlank(message = "Answer value field is required")
    private String answerValue;
}

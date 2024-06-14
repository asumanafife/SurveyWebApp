package com.aydinsurveyapp.survey.dto;

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
public class QuestionValueEditDTO {

    @NotNull(message = "Question Id is required")
    private Integer questionId;

    @NotNull(message = "Value is required")
    private String value;

  
}

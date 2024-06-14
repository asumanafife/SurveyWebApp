package com.aydinsurveyapp.survey.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SurveyEditDTO {

    @NotBlank(message = "Survey title field is required")
    private String surveyTitle;

    @NotBlank(message = "Description field is required")
    private String description;

    private Date startDate;

    private Date endDate;
}

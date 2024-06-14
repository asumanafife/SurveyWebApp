
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
public class QuestionTypeEditDTO {

    @NotNull(message = "Type Id is required")
    private Integer typeId;

    @NotNull(message = "Name is required")
    private String name;

}

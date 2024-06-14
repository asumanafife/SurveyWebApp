package com.aydinsurveyapp.survey.dto;

import jakarta.validation.constraints.NotBlank;
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
public class UserEditDTO {

    @NotBlank(message = "Username field is required")
    private String username;

    @NotBlank(message = "Password field is required")
    private String password;
}


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
public class ParticipantEditDTO {

    @NotBlank(message = "First name field is required")
    private String firstName;

    @NotBlank(message = "Last name field is required")
    private String lastName;

    @NotBlank(message = "Email field is required")
    private String eMail;

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String email) {
        this.eMail = email;
    }
}

package com.aydinsurveyapp.survey.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ErrorDTO {
    private String msg;

    private Long timestamp;

    private List<String> errors;

    public ErrorDTO(String message, List<String> errors) {
        this.errors = errors;
        this.msg = message;
        this.timestamp = System.currentTimeMillis() / 1000;

    }
}

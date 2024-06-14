package com.aydinsurveyapp.survey.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aydinsurveyapp.survey.dto.ErrorDTO;

@Configuration
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDTO> notFound(NotFoundException ex){
        return new ResponseEntity<ErrorDTO>(
            new ErrorDTO(ex.getMessage(), null),
            HttpStatusCode.valueOf(404)
        );

    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorDTO> badRequest(BadRequestException ex){
        return new ResponseEntity<ErrorDTO>(
            new ErrorDTO(ex.getMessage(), null),
            HttpStatus.valueOf(400)
        );
        
    }
    @ExceptionHandler({InternalServerErrorException.class})
    public ResponseEntity<ErrorDTO> internalServerError(InternalServerErrorException ex){
        return new ResponseEntity<ErrorDTO>(
            new ErrorDTO(ex.getMessage(), null),
            HttpStatus.valueOf(500)
        );
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorDTO> notReadable(HttpMessageNotReadableException ex){
        return new ResponseEntity<ErrorDTO>(
            new ErrorDTO("Json verisi okunamadı",  null),
            HttpStatus.valueOf(400)
        );
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> notValidationError(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for(var er: ex.getAllErrors()) {
            errors.add(er.getDefaultMessage());
        }

        return new ResponseEntity<ErrorDTO>(
            new ErrorDTO("Json verisi okunamadı",  errors),
            HttpStatus.valueOf(400)
        );
    }

}

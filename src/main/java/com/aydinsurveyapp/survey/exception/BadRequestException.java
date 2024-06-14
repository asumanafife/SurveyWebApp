package com.aydinsurveyapp.survey.exception;

public class BadRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5026970103087637747L;

	public BadRequestException(String msg){
        super(msg);
    }
}

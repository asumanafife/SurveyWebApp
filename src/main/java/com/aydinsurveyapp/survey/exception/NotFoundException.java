package com.aydinsurveyapp.survey.exception;

public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -379009524683360306L;

	public NotFoundException(String msg){
        super(msg);
    }
}

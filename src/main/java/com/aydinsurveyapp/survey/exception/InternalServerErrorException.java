package com.aydinsurveyapp.survey.exception;

public class InternalServerErrorException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8961350164424794448L;

	public InternalServerErrorException(String msg){
        super(msg);
    }
}

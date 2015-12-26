package elo7.nasa.exception;

public class ProcessingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcessingException(){
		
	}
	
	public ProcessingException(String message){
		super(message);
	}
}

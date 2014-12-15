package kr.co.aegis.core.exception;


public class CheckedException extends Exception {

	private static final long serialVersionUID = 1L;
	private String[] args = null;
	
	public CheckedException(String message) {
		super(message);
	}
	
	public CheckedException(String message, String[] args) {
		super(message);
		this.args = args;
	}
	
	public String[] getArgs(){
		return args;
	}
}

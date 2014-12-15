package kr.co.aegis.core.exception;

public class DataIntegrityException extends UncheckedException {
	
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Data Integrity Exception. Check processed count.";
	
	public DataIntegrityException() {
		super(MESSAGE);
	}
	
	public DataIntegrityException(String message) {
		super(message);
	}
	
}

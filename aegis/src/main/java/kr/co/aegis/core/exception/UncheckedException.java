package kr.co.aegis.core.exception;

public class UncheckedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UncheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UncheckedException(Throwable cause) {
		super(cause);
	}
	
	public UncheckedException(String message) {
		super(message);
	}
}

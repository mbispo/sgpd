package br.jus.tjms.sgpd.exception;

public class SGPException extends RuntimeException {

	private static final long serialVersionUID = 643058030945176544L;

	public SGPException() {
		super();
	}

	public SGPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SGPException(String message, Throwable cause) {
		super(message, cause);
	}

	public SGPException(String message) {
		super(message);
	}

	public SGPException(Throwable cause) {
		super(cause);
	}

}

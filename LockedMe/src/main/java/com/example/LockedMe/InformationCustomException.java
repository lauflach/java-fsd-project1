package com.example.LockedMe;

public class InformationCustomException extends Exception {
	
	private String errorCode = "";

	public InformationCustomException(String code) {
		super(code);
		this.errorCode = code;
		// TODO Auto-generated constructor stub
	}

	public InformationCustomException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InformationCustomException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

//	public InformationCustomException(String message) {
//		super(message);
//		// TODO Auto-generated constructor stub
//	}

	public InformationCustomException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}

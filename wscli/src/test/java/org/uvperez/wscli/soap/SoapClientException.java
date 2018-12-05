package org.uvperez.wscli.soap;

import java.io.IOException;

public class SoapClientException extends IOException {
	private static final long serialVersionUID = -9110537203099530211L;

	private int statusCode;
	
	public SoapClientException() {
		super();
	}

	public SoapClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public SoapClientException(String message) {
		super(message);
	}

	public SoapClientException(Throwable cause) {
		super(cause);
	}

	public SoapClientException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
	

}

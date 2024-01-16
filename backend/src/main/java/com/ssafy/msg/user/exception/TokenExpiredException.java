package com.ssafy.msg.user.exception;

public class TokenExpiredException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TokenExpiredException() {
		super("ExpiredTokenException");
	}
}

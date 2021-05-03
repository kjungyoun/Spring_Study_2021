package com.ssafy.book.dto;


public class BookException extends RuntimeException {
	public BookException() {
		super("Book 정보를 처리 중 오류 발생");
	}
	public BookException(String msg) {
		super(msg);
	}
}

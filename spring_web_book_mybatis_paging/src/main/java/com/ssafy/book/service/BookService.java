package com.ssafy.book.service;

import java.util.List;

import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.PageBean;

public interface BookService {
	public List<Book>  searchAll(PageBean bean);
	public Book search(String isbn);
	public void insert(Book book);
	public void update(Book book);
	public void delete(String isbn);
}




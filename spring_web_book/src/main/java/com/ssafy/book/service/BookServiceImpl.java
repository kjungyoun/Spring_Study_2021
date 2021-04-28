package com.ssafy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dao.BookDao;
import com.ssafy.book.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao dao;
	
	public List<Book> searchAll() {
		return dao.searchAll();
	}
	public Book search(String isbn) {
		return dao.search(isbn);
	}
	public void insert(Book book) {
		dao.insert(book);
	}
	public void update(Book book) {
		dao.update(book);
	}
	public void delete(String isbn) {
		dao.delete(isbn);
	}
}

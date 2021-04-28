package com.ssafy.book.dao;

import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookDao {
	public List<Book>  searchAll();
	public Book  search(String isbn);
	public void insert(Book book);
	public void update(Book book);
	public void delete(String isbn);
}

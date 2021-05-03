package com.ssafy.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.book.dto.Book;

@Mapper
public interface BookDao {
	public List<Book>  searchAll();
	public Book  search(String isbn);
	public void insert(Book book);
	public void update(Book book);
	public void delete(String isbn);
}

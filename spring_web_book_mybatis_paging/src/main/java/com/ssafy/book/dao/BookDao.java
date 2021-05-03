package com.ssafy.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.PageBean;

@Mapper
public interface BookDao {
	public List<Book>  searchAll(PageBean bean);
	public Book  search(String isbn);
	public void insert(Book book);
	public void update(Book book);
	public void delete(String isbn);
	public int getTotalCount(PageBean bean);
}

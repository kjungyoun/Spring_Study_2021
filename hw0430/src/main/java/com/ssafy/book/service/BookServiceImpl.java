package com.ssafy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.book.dao.BookDao;
import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.PageBean;
import com.ssafy.book.util.PageUtility;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao dao;
	
	@Transactional
	public List<Book> searchAll(PageBean bean) {
		int total = dao.getTotalCount(bean);
		PageUtility util = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
		bean.setPageLink(util.getPageBar());
		return dao.searchAll(bean);
	}
	
	@Transactional
	public Book search(String isbn) {
		return dao.search(isbn);
	}
	
	@Transactional
	public void insert(Book book) {
		dao.insert(book);
	}
	
	@Transactional
	public void update(Book book) {
		dao.update(book);
	}
	
	@Transactional
	public void delete(String isbn) {
		dao.delete(isbn);
	}
}

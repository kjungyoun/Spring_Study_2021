package com.ssafy.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.PageBean;
import com.ssafy.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@GetMapping("listBook.do")
	public String listBook(@ModelAttribute("bean") PageBean bean, Model model) {
		model.addAttribute("list", bookService.searchAll(bean));
		return "book/listBook";
	}
	
	@GetMapping("searchBook.do")
	public String searchBook(String isbn,Model model) {
		model.addAttribute("book", bookService.search(isbn));
		return "book/searchBook";
	}
	
	@GetMapping("insertBookForm.do")
	public String insertBookForm() {
		return "book/insertBook";
	}
	
	@GetMapping("updateBookForm.do")
	public String updateBookForm(Model model, String isbn) {
		model.addAttribute("book", bookService.search(isbn));
		return "book/updateBook";
	}
	
	@GetMapping("removeBook.do")
	public String removeBook(String isbn) {
		bookService.delete(isbn);
		return "redirect:listBook.do";
	}
	
	@PostMapping("insertBook.do")
	public String insertBook(Book book) {
		bookService.insert(book);
		return "redirect:searchBook.do?isbn=" + book.getIsbn();
	}
	
	@PostMapping("updateBook.do")
	public String updateBook(Book book) {
		bookService.update(book);
		return "book/updateBook";
	}
	
	
}










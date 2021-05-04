package com.ssafy.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.dto.Book;
import com.ssafy.book.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value="SSAFY", description = "SSAFY Resources Management 2021")
public class BookControllerRest {
		
	private static final Logger logger = LoggerFactory.getLogger(BookControllerRest.class);
	
	@Autowired
	private BookService bookService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@GetMapping("book")
	@ApiOperation("책 목록 표시")
	public ResponseEntity<List<Book>> listBook(Model model) {
		model.addAttribute("list", bookService.searchAll());
		return new  ResponseEntity<List<Book>>(bookService.searchAll(), HttpStatus.OK);
	}
	
	@GetMapping("book/{isbn}")
	@ApiOperation("책 정보 표시")
	public ResponseEntity<Book> searchBook(@PathVariable String isbn,Model model) {
		model.addAttribute("book", bookService.search(isbn));
		return new ResponseEntity<Book>(bookService.search(isbn),HttpStatus.OK);
	}
	
//	@GetMapping("book/{pageinfo}")
//	@ApiOperation("책 정보 표시")
//	public ResponseEntity<String> searchBook(@PathVariable List<String> pageinfo) {
//		for (String string : pageinfo) {
//			logger.info(string);
//		}
//		return new ResponseEntity<String>("잘되용!!!",HttpStatus.OK);
//	}
	
	@GetMapping("book/{no}/{key}/{word}")
	@ApiOperation("책 정보 표시")
	public ResponseEntity<String> searchBook(@PathVariable String no, @PathVariable String key, @PathVariable String word) {
		logger.info(no);
		logger.info(key);
		logger.info(word);
		return new ResponseEntity<String>("잘되용!!!",HttpStatus.OK);
	}
	
	
//	
//	@GetMapping("insertBookForm.do")
//	public String insertBookForm() {
//		return "book/insertBook";
//	}
//	
//	@GetMapping("updateBookForm.do")
//	public String updateBookForm(Model model, String isbn) {
//		model.addAttribute("book", bookService.search(isbn));
//		return "book/updateBook";
//	}
//	
//	@GetMapping("removeBook.do")
//	public String removeBook(String isbn) {
//		bookService.delete(isbn);
//		return "redirect:listBook.do";
//	}
//	
//	@PostMapping("insertBook.do")
//	public String insertBook(Book book) {
//		bookService.insert(book);
//		return "redirect:searchBook.do?isbn=" + book.getIsbn();
//	}
//	
//	@PostMapping("updateBook.do")
//	public String updateBook(Book book) {
//		bookService.update(book);
//		return "book/updateBook";
//	}
	
	
}










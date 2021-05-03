
package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value="SSAFY", description="SSAFY Product Swagger Main Controller")
public class MainControllerRest {
	
	@Autowired
	ProductService pService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
//	@GetMapping("mvInsert")
//	public String mvInsert() {
//		return "product/insert";
//	}
	
	@PutMapping("product")
	@ApiOperation("제품 등록")
	public ResponseEntity insertProduct(@RequestBody Product product) {
		pService.insertProduct(product);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("product")
	@ApiOperation("제품 목록 조회")
	public ResponseEntity<List<Product>> listProduct(Model model, @RequestBody PageBean bean) {
		model.addAttribute("list", pService.searchAll(bean));
		return new ResponseEntity<List<Product>>(pService.searchAll(bean),HttpStatus.OK);
		
	}
	
	@GetMapping("product/{productno}")
	@ApiOperation("제품 조회")
	public ResponseEntity<Product> search(Model model, @PathVariable int productno) {
		model.addAttribute("product", pService.getProduct(productno));
		return new ResponseEntity<Product>(pService.getProduct(productno), HttpStatus.OK);
	}
}


package com.ssafy.product.controller;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService pService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@GetMapping("mvInsert")
	public String mvInsert() {
		return "product/insert";
	}
	@PostMapping("insertProduct")
	public String insertProduct(Product product) {
		pService.insertProduct(product);
		return "redirect:listProduct";
	}
	
	
	@GetMapping("listProduct")
	public String listProduct(Model model, @ModelAttribute("bean") PageBean bean) {
		model.addAttribute("list", pService.searchAll(bean));
		return "product/listProduct";
	}
	@GetMapping("search")
	public String search(Model model, int productno) {
		model.addAttribute("product", pService.getProduct(productno));
		return "product/insertsuccess";
	}
}

package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.MemberDto;
import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.LoginService;
import com.ssafy.product.model.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ProductService productService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@PostMapping("login.do")
	public String login(String userid, String userpwd, Model model) {
		try {
			MemberDto member = loginService.login(userid, userpwd);
			if(member!=null) {
				model.addAttribute("userinfo", member);
			}else {
				model.addAttribute("msg", "아이디와 비밀번호를 확인하세요");
			}
			return "product/login";				
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg","로그인 중 오류발생!!");
			return "error/error";
		}
	}
	
	@GetMapping("listProduct.do")
	public String list(PageBean bean , Model model) {
		int pageno = bean.getPageNo();
		bean.setPageNo(pageno == 0 ? 1 : pageno);
		List<Product> list = productService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("bean", bean);
		return "product/listProduct";
	}
	
	@GetMapping("search.do")
	public String search(int productno, Model model) {
		Product product = productService.getProduct(productno);
		model.addAttribute("product",product );
		return "product/insertsuccess";
	}
	
	@GetMapping("mvInsert.do")
	public String mvInsert() {
		return "product/insert";
	}
	
	@PostMapping("insert")
	public String insert(Product product, Model model) {
		productService.insertProduct(product);
		model.addAttribute("product", product);
		return "product/insertsuccess";
	}
	
	
	
}

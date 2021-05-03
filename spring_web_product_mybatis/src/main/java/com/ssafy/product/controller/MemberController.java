package com.ssafy.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.MemberDto;
import com.ssafy.product.model.dto.ProductException;
import com.ssafy.product.model.service.LoginService;

@Controller
public class MemberController {
	
	@Autowired
	private LoginService loginService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@PostMapping("login.do")
	public String login(MemberDto member, HttpServletRequest request) {
		try {
			MemberDto mem = loginService.login(member);
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", mem);
		} catch (ProductException e) {
			request.setAttribute("msg", e.getMessage());
		}
		
		return "index";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
	
}

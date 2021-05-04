package com.ssafy.board.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.PageBean;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.MemberService;

@Controller
public class MemberController {
	
	 @Autowired
	 private MemberService service;
	 
	 @ExceptionHandler
	 public ModelAndView handler(Exception e) {
		 e.printStackTrace();
		 ModelAndView mav = new ModelAndView("ErrorHandler");
		 mav.addObject("msg", e.getMessage());
		 return mav;
	 }
	 
	 @GetMapping("loginform.do")
	 public String loginform() {
		 return "member/login";
	 }
	 @GetMapping("logout.do")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "member/login";
	 }
	 @PostMapping("login.do")
	 public String login(String id, String pw, Model model, HttpSession session) {
		 try {
			service.login(id, pw);
			session.setAttribute("id", id);
			return "redirect:listBoard.do";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "member/login";
		}
		 
	 }
}






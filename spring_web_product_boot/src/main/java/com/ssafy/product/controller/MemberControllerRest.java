package com.ssafy.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.MemberDto;
import com.ssafy.product.model.dto.ProductException;
import com.ssafy.product.model.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin("*")
@Api(value="SSAFY", description="SSAFY Swagger MemberController")
public class MemberControllerRest {
	
	@Autowired
	private LoginService loginService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error/error");
		mav.addObject("msg", e.getMessage());
		e.printStackTrace();
		return mav;
	}
	
	@PostMapping("product/user")
	@ApiOperation("로그인 구현")
	public ResponseEntity<MemberDto> login(@RequestBody @ApiParam(value="로그인 정보", required = true) MemberDto member, HttpServletRequest request) {
		try {
			MemberDto mem = loginService.login(member);
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", mem);
			if(mem != null) {
				return new ResponseEntity<MemberDto>(mem, HttpStatus.OK);
			}
				
		} catch (ProductException e) {
			request.setAttribute("msg", e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("product/user")
	@ApiOperation("로그아웃")
	public ResponseEntity logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity(HttpStatus.OK);
	}
	
}

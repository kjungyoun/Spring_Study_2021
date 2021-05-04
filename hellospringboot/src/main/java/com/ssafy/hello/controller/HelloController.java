package com.ssafy.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {

	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("msg", "안녕 스프링부트야!!!(jsp)");
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "sub/test";
	}
}

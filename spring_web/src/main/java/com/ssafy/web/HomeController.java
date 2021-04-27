package com.ssafy.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.web.dto.ParamDto;
import com.ssafy.web.service.HelloService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HelloService helloService;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//화면에 표시할 object 추가
		mav.addObject("msg", helloService.greeting());
		// mav의 이름 설정 (view 페이지의 이름)
		mav.setViewName("step01/hello");
		return mav;
	}
	
	// get과 post방식이 합쳐진 것
	@GetMapping("/form")
	public String form() {
		return "step02/form";
	}
	
	@GetMapping("/sendparam")
	public String param(String userid, @RequestParam("username") String name, @RequestParam String area) {
		System.out.println(userid+" " + name+" " + area);
		return "step02/form";
	}
	
	@PostMapping("/sendparam")
		public String param(ParamDto paramDto, Model model) {
			model.addAttribute("userinfo", paramDto);
			return "step02/result";
		}
}

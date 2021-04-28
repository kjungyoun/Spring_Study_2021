package com.ssafy.web;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
//	@RequestMapping(value = "/hello")
//	public ModelAndView hello() {
//		ModelAndView mav = new ModelAndView();
//		//화면에 표시할 object 추가
//		mav.addObject("msg", helloService.greeting());
//		// mav의 이름 설정 (view 페이지의 이름)
//		mav.setViewName("step01/hello");
//		return mav;
//	}
	
	/* 2.1 version
	 * String
    	→ 인자명으로 요청 데이터를 추출
    	ex) String userid ⇒ String userid = request.getParameter("userid");
    	→ 요청 패킷에 userid라는 데이터가 없어도, userid에 대한 값이 없어도 error가 발생하지 않음
	 */
//	@RequestMapping("/hello")
//	public String hello(String price) {
//		System.out.println("price: "+price);
//		return "step01/hello";
//	}
	
	// 2.2 version
	/*
	 * - Primitive type (byte, short, char, int, long, float, double, boolean)
    		→ 인자명으로 요청 데이터를 추출해서 지정한 타입으로 변경
    		ex) int price  ⇒ int price = Integer.parseInt(request.getParameter("price"));
    		→ NumberFormatException이 발생할 가능성이 있다.
    		→ 요청 패킷에 데이터가 없으면 500 error 발생
    		→ 요청 패킷에 데이터가 있지만 값이 없을 때 400 error 발생
	 */
//		@RequestMapping("/hello")
//		public String hello(int price) {
//			System.out.println("price: "+price);
//			return "step01/hello";
//		}
	
	// 2.3.1 version - required
	// http://localhost:8080/web/hello?price=4000
	// http://localhost:8080/web/hello?price=
	// http://localhost:8080/web/hello
//	@RequestMapping("/hello")
//	public String hello(@RequestParam (value="price", required = true) String price) {
//		System.out.println("price: "+price);
//		return "step01/hello";
//	}
	
	// 2.3.2 version - defaultValue 실습
	// http://localhost:8080/web/hello?price=4000
	// http://localhost:8080/web/hello?price=
	// http://localhost:8080/web/hello
//		@RequestMapping("/hello")
//		public String hello(@RequestParam (value="price", required = true, defaultValue="5000") int price) {
//			System.out.println("price: "+price);
//			return "step01/hello";
//		}
	
	// 2.4 version - @RequestParam map 실습 : 모든 요청 정보를 다 추출해서 map에 담아줌
	// http://localhost:8080/web/hello?price=4000&name=ssafy&age=5
//	@RequestMapping("/hello")
//	public String hello(@RequestParam Map<String,String> map) {
//		System.out.println("요청 데이터 : "+map);
//		return "step01/hello";
//	}
	
	
	// get방식이 들어왔을 때
	@GetMapping("/form")
	public String form() {
		return "step02/form";
	}
	
	@GetMapping("/sendparam")
	public String param(String userid, @RequestParam("username") String name, @RequestParam String area) {
		System.out.println(userid+" " + name+" " + area);
		return "step02/form";
	}
	
//	 2.5 version 실습
//	@PostMapping("/sendparam")
//		public String param(ParamDto paramDto, Model model) {
//			model.addAttribute("userinfo", paramDto);
//			return "step02/result";
//		}
	
	
	// 2.6 version - 2.5와 동일하며 request에 저장할 이름을 지정할 수 있다.
	@PostMapping("/sendparam")
	public String param(@ModelAttribute("userinfo")ParamDto paramDto, Model model) {
		return "step02/result";
	}
	
	// 2.7 version
	// http://localhost:8080/web/hello?msg=hi
	@RequestMapping("/hello")
	public String hello(String msg, Model model) {
		System.out.println("요청 데이터 : "+msg);
		model.addAttribute("msg", msg);
		return "step01/hello";
	}
	
	// 3.1 redirect
	// http://localhost:8080/web/
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:hello";
	}
	
	// 3.2
	// http://localhost:8080/web/index.do
	@RequestMapping("/index.do")
	public void index() {
		// index.jsp로 이동한다.
	}
	
	// 3.4 version RESTFull 서비스 테스트
	// http://localhost:8080/web/rest/seoul
	@GetMapping("/rest/{sido}")
	@ResponseBody
	public ParamDto rest(@PathVariable String sido) {
		System.out.println("path varable: " + sido);
		ParamDto dto = new ParamDto();
		dto.setUserid("ssafy");
		dto.setUsername("싸피");
		ArrayList<String> list = new ArrayList<String>(2);
		list.add("사과");
		list.add("딸기");
		dto.setFruit(list);
		return dto;
	}
	
	// 4.0 version
	// http://localhost:8080/web/error
	@GetMapping("/error")
	public void error() {
		throw new RuntimeException("예외처리 잘되나?");
	}
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("/error");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
}

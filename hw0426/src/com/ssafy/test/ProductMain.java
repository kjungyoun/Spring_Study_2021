package com.ssafy.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		// Bean Configuration인 Context를 가져옴 (의존 정보)
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/configuration/applicationContext.xml");
		
		ProductService productService = context.getBean("pservice", ProductServiceImpl.class);
		
		List<Product> list = new ArrayList<Product>();
		
		try {
			System.out.println(productService.select("1000"));
			System.out.println(productService.insert(new Product("4000","갤럭시노트","Samsung",1250000,"갤럭시 노트 20")));
			list = productService.selectAll();
			
			for (Product product : list) {
				System.out.println(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
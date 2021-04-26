package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		// 새로 만든 Bean 설정 파일을 불러온다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
		System.out.println("xml readed!!!");
//		HelloMessage helloMessage = (HelloMessage) context.getBean("kor");
		// bean 설정파일에서 id가 kor이라는 것의 클래스를 가져온다.
		HelloMessage helloMessage = context.getBean("kor", HelloMessageKor.class);
//		HelloMessage helloMessage = context.getBean("eng", HelloMessageEng.class);
		
		String greeting = helloMessage.hello("안효인");
//		String greeting = helloMessage.hello("Mr. An");
		
		System.out.println(greeting);
		
		System.out.println("----------------------------------------");
		
		HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
		HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
		System.out.println(kor1 + " ::::: " + kor2);
	}
	
}

package com.ssafy.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class GuestbookSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookSpringbootApplication.class, args);
	}

}

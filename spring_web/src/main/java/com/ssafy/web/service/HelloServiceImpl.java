package com.ssafy.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.web.dao.HelloDao;

@Service
public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private HelloDao helloDao;
	
	
	@Override
	public String greeting() {
	
		return helloDao.greeting();
	}

}

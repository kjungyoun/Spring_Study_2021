package com.ssafy.web.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImpl implements HelloDao {

	@Override
	public String greeting() {
		return "점심 맛있게 드세요";
	}

}

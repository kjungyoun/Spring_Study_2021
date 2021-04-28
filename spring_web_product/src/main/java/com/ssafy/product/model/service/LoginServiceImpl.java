package com.ssafy.product.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dao.LoginDao;
import com.ssafy.product.model.dto.MemberDto;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;
	
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		return dao.login(userid, userpwd);
	}
}

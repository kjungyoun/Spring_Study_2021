package com.ssafy.product.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.LoginDao;
import com.ssafy.product.model.dto.MemberDto;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;
	
	@Transactional
	@Override
	public MemberDto login(Map<String,String>map) throws Exception {
		return dao.login(map);
	}
}

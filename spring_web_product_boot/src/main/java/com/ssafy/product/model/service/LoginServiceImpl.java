package com.ssafy.product.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.LoginDao;
import com.ssafy.product.model.dto.MemberDto;
import com.ssafy.product.model.dto.ProductException;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;
	
	@Transactional
	@Override
	public MemberDto login(MemberDto mem)throws ProductException{
		MemberDto member = dao.login(mem);
		if (member != null) {
			if(member.getUserpwd().equals(mem.getUserpwd())){
				return member;
			}else {
				throw new ProductException("비밀번호 오류");
			}
		}else {
			throw new ProductException("등록되지 않은 아이디입니다.");
		}
	}
}

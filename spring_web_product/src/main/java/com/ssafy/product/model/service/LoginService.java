package com.ssafy.product.model.service;

import com.ssafy.product.model.dto.MemberDto;

public interface LoginService {
	public MemberDto login(String userid, String userpwd) throws Exception;
}

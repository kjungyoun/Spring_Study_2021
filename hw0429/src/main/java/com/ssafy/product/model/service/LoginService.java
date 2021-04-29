package com.ssafy.product.model.service;

import java.util.Map;

import com.ssafy.product.model.dto.MemberDto;

public interface LoginService {
	public MemberDto login(Map<String,String> map) throws Exception;
}

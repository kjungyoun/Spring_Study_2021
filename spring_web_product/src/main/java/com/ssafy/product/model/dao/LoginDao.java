package com.ssafy.product.model.dao;

import java.sql.SQLException;

import com.ssafy.product.model.dto.MemberDto;

public interface LoginDao {
	public MemberDto login(String userid, String userpwd) throws SQLException;
}

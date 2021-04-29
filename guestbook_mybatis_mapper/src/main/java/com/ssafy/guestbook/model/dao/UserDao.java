package com.ssafy.guestbook.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.guestbook.model.MemberDto;

@Mapper
public interface UserDao {

	public MemberDto login(Map<String, String> map) throws SQLException;
	
}

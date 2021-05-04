package com.ssafy.product.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.product.model.dto.MemberDto;

@Mapper
public interface LoginDao {
	public MemberDto login(MemberDto member) ;
}

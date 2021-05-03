package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.dto.PageBean;

@Mapper
public interface MemberDao {
	void insert(Member member);
	void update(Member member);
	void remove(String id);
	Member search(String id);
	List<Member> searchAll(PageBean bean);
	int getCount(PageBean bean);
}

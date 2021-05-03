package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.dto.PageBean;

public interface MemberService {
	boolean login(String id, String pwd);
	Member search(String id);
	List<Member> searchAll(PageBean bean);
	void insert(Member member);
	void update(Member member);
	void remove(String id);
}

package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.MemberDao;
import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.dto.PageBean;


public interface MemberService {
	boolean login(String id, String pw);
	Member  search(String id);
	List<Member> searchAll(PageBean bean);
	void insert(Member member);
	void update(Member member);
	void remove(String id);
}

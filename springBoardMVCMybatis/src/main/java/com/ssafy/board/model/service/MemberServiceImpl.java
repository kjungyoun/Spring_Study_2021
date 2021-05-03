package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.MemberDao;
import com.ssafy.board.model.dto.BoardException;
import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.dto.PageBean;
import com.ssafy.board.util.PageUtility;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao dao;

	@Transactional
	@Override
	public boolean login(String id, String pwd) {
		Member member = dao.search(id);
		if(member != null) {
			if(pwd.equals(member.getPassword())) {
				return true;
			}else {
				throw new BoardException("비밀 번호를 다시 한번 체크해주세요.");
			}
		}else {
			throw new BoardException("등록되지 않은 아이디 입니다.");
		}
	}

	@Transactional
	@Override
	public Member search(String id) {
		return dao.search(id);
	}
	
	@Transactional
	@Override
	public List<Member> searchAll(PageBean bean) {
			int total = dao.getCount(bean);
			try {
				PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
				bean.setPageLink(bar.getPageBar());
				return dao.searchAll(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Transactional
	@Override
	public void insert(Member member) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

}

package com.ssafy.board.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.BoardException;
import com.ssafy.board.model.dto.BoardFile;
import com.ssafy.board.model.dto.PageBean;
import com.ssafy.board.util.PageUtility;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao ;
	
	@Transactional
	public void insertBoard(Board board) {
		File[] realFile = null;
		int size =0;
		try {
			int no = dao.getBoardNo();
			board.setNo(no);
			dao.insert( board);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new BoardException("게시글 작성 중 오류 발생");
		}
	}
	@Transactional
	public void updateBoard(Board board) {
		dao.update( board);
	}
	
	@Transactional
	public void deleteBoard(String no) {
		dao.remove( no);
		dao.removeFile(Integer.parseInt(no));
	}
	
	@Transactional
	public Board search(String no) {
		return dao.search(no);
	}
	
	@Transactional
	public List<Board> searchAll(PageBean bean) {
		try {
			int total = dao.getCount(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPageLink(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BoardException("게시물 검색 중 오류 발생");
		}
	}
}















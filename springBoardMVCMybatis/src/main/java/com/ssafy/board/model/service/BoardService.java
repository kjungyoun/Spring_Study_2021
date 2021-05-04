package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.PageBean;

public interface BoardService {
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(String no);
	public Board search(String no);
	public List<Board> searchAll(PageBean bean);
}

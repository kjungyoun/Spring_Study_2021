package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.BoardFile;
import com.ssafy.board.model.dto.PageBean;

@Mapper
public interface BoardDao {
	int getBoardNo();
	void insert(Board board);
	void insertFile(BoardFile file);
	Board search(String no);
	List<Board> searchAll(PageBean bean);
	int getCount(PageBean bean);
	void update(Board board);
	void remove(String no);
	void removeFile(int bno);
}

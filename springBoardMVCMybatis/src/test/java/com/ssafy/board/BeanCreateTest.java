package com.ssafy.board;


import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.MemberDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Member;
import com.ssafy.board.model.dto.PageBean;
import com.ssafy.board.model.service.MemberService;
import com.ssafy.board.model.service.MemberServiceImpl;

@RunWith(SpringRunner.class)			//spring container
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BeanCreateTest {

	private static Logger logger = LoggerFactory.getLogger(BeanCreateTest.class);
	
	@Autowired
	MemberDao mdao;
	@Autowired
	BoardDao  bdao;
	
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	DataSource ds;
	@Test
	public void testBeanCreation() {
		Assert.assertNotNull(mdao);
		Assert.assertNotNull(bdao);
		Assert.assertNotNull(mservice);
	}
	
	@Test
	public void testLogin() {
		Assert.assertTrue(mservice.login("ssafy", "ssafy"));
	}
	
	@Test
	public void testSearchBoard() {
		logger.debug("board search test");
		List<Board> boards = bdao.searchAll(new PageBean());
		for (Board board : boards) {
			logger.debug(board.toString());
		}
	
	}
	
	
	
	
	
	@Test 
	public void testDataSource() {
		logger.debug("datasource 확인:{}",ds);
		Assert.assertNotNull(ds);
	}	
	
	@Test
	public void searchMember() {
		List<Member> list = mdao.searchAll(new PageBean());
		logger.debug("member searchAll 확인");
		for (Member member : list) {
			logger.debug(member.toString());
		}
	}
}









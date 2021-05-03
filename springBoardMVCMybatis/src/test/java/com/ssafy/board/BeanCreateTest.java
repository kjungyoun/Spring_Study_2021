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

@RunWith(SpringRunner.class) 	// spring container
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
								 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BeanCreateTest {
	
		private static Logger logger = LoggerFactory.getLogger(BeanCreateTest.class);
		
		@Autowired
		MemberDao mdao;
		
		@Autowired
		DataSource ds;
		
		@Autowired
		BoardDao bdao;
		
		@Autowired
		MemberService mservice;
		
		@Test
		public void testBeanCreation() {
			Assert.assertNotNull(mdao);
			Assert.assertNotNull(bdao);
			Assert.assertNotNull(mservice);
		}
		
		@Test 
		public void testDataSource() {
			logger.debug("datasource 확인:{}",ds);
			Assert.assertNotNull(ds);
		}
		
		@Test
		public void searchMember() {
			List<Member> list = mdao.searchAll(new PageBean());
			System.out.println("member searchAll 확인");
			for (Member member : list) {
				logger.debug(member.toString());
			}
		}
		
		@Test
		public void searchBoard() {
			List<Board>list = bdao.searchAll(new PageBean());
			System.out.println("board searchAll 확인");
			for (Board board : list) {
				logger.debug(board.toString());
			}
		}
		
		@Test
		public void testLogin() {
			Assert.assertTrue(mservice.login("ssafy", "ssafy"));
		}
}

package com.ssafy.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.BookException;
import com.ssafy.book.util.DBUtil;

@Repository
public class BookDaoImpl implements BookDao {
	
	public void insert(Book book){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" insert into book(isbn,title,catalogue,nation, publish_date, publisher, author,price,currency, description) "
					  + " values(?,?,?,?,now(),?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setString( 1, book.getIsbn());
			stmt.setString( 2, book.getTitle());
			stmt.setString( 3, book.getCatalogue());
			stmt.setString( 4, book.getNation());
			stmt.setString( 5, book.getPublisher());
			stmt.setString( 6, book.getAuthor());
			stmt.setInt(7, book.getPrice());
			stmt.setString( 8, book.getCurrency());
			stmt.setString( 9, book.getDescription());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new BookException("책 정보를 등록하는 중 오류 발생");
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void update(Book book){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" update book set title=?,author=?,publisher=?,price=?,description=? "
					  + " where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString( 1, book.getTitle());
			stmt.setString( 2, book.getAuthor());
			stmt.setString( 3, book.getPublisher());
			stmt.setInt(4, book.getPrice());
			stmt.setString( 5, book.getDescription());
			stmt.setString( 6, book.getIsbn());
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new BookException("책 정보를 수정하는 중 오류 발생");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void delete(String isbn){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" delete from book where isbn=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString( 1, isbn);
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new BookException("책 정보를 삭제하는 중 오류 발생");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public Book search(String isbn){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select * from book where isbn = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Book book =  new Book();
				book.setIsbn(isbn);
				book.setTitle(rs.getString("title"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setNation(rs.getString("nation"));
				book.setPublish_date(rs.getString("publish_date"));
				book.setPublisher(rs.getString("publisher"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setCurrency(rs.getString("currency"));
				book.setDescription(rs.getString("description"));
				return book;
			}
		}catch(SQLException e) {
			throw new BookException("책 정보를 조회하는 중 오류 발생");
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	public List<Book> searchAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select * from book ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Book> books = new LinkedList<Book>();
			while(rs.next()) {
				books.add(new Book(rs.getString("isbn")
							 , rs.getString("title")
							 , rs.getString("publisher")
							 , rs.getString("author")
							 , rs.getInt("price")
							 , rs.getString("description")));
			}
			return books;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new BookException("책 목록을 조회하는 중 오류 발생");
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public int count() throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select count(*) as cnt from book ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Book> books = new LinkedList<Book>();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return 0;
	}
}






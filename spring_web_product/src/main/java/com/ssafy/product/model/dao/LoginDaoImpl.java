package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.product.model.dto.MemberDto;
import com.ssafy.product.util.DBUtil;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	DBUtil util = new DBUtil();
	
	
	@Override
	public MemberDto login(String userid, String userpwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from ssafy_member where userid=? and userpwd=? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new MemberDto(
						userid,
						rs.getString("username"),
						userpwd,
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("joindate")
						);
			}
			
		} finally {
			util.close(conn);
			util.close(pstmt);
			util.close(rs);
		}
		
		return null;
	}

}

package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.util.DBUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public void insertProduct(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into product (productno,name, price, info) \n");
			insertMember.append("values(?,?, ?, ?)");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setInt(1, product.getProductno());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getInfo());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}

	}

	public int getLastNo(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql =" select LAST_INSERT_ID() as id from dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			}else {
				throw new SQLException("ID 추출 오류");
			}
		}finally {
			DBUtil.close(pstmt);
		}
		
	}
	@Override
	public Product getProduct(int productno) throws SQLException {
		Product productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" select * \n");
			sql.append(" from product \n");
			sql.append(" where productno = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, productno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				productDto = new Product();
				productDto.setProductno(rs.getInt("productno"));
				productDto.setName(rs.getString("name"));
				productDto.setPrice(rs.getInt("price"));
				productDto.setInfo(rs.getString("info"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return productDto;
	} 
	
	public List<Product> searchAll(Connection conn, PageBean bean) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new LinkedList<Product>();
		try {
			String key = bean.getKey();
			String word= bean.getWord();
			int startNo= bean.getStartNo();
			int interval=bean.getInterval();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from product  \n");
			//검색 조건에 맞는 쿼리 작성 => 동적 쿼리 
			if(key != null && !key.equals("all") && word !=null && !word.trim().equals("")) {
				if(key.equals("name")) {
					sql.append(" where name like ? \n");
				}else if(key.equals("price")) {
					sql.append(" where price <= ?  \n");
				}
			}
			sql.append(" order by productno desc  limit  ?, ? ");
			
			pstmt = conn.prepareStatement(sql.toString());

			//데이타 설정 
			int idx = 1;  //? 번호를 위한 변수   => 조건에 따라서 ?의 번호가 달라지므로 변수를 사용한다. 
			
			if(key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if(key.equals("name")) {
					pstmt.setString(idx++, "%"+word+"%");
				}else if(key.equals("price")) {
					pstmt.setInt(idx++, Integer.parseInt(word.trim()));
				}
			}
			
			pstmt.setInt(idx++, startNo);
			pstmt.setInt(idx++, interval);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product productDto = new Product();
				productDto.setProductno(rs.getInt("productno"));
				productDto.setName(rs.getString("name"));
				productDto.setPrice(rs.getInt("price"));
				list.add(productDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return list;
	}
	public int totalCount(Connection conn, PageBean bean) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word= bean.getWord();
			int startNo= bean.getStartNo();
			int interval=bean.getInterval();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) as cnt from product  \n");
			//검색 조건에 맞는 쿼리 작성 => 동적 쿼리 
			if(key != null && !key.equals("all") && word !=null && !word.trim().equals("")) {
				if(key.equals("name")) {
					sql.append(" where name like ? \n");
				}else if(key.equals("price")) {
					sql.append(" where price <= ?  \n");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());

			if(key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if(key.equals("name")) {
					pstmt.setString(1, "%"+word+"%");
				}else if(key.equals("price")) {
					pstmt.setInt(1, Integer.parseInt(word.trim()));
				}
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
		}
		return 1;
	}
	public void remove(int productNo) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " delete from product where productno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
}






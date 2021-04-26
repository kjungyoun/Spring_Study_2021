package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ssafy.model.dto.Product;
import com.ssafy.util.DBUtil;

public class ProductRepoImpl implements ProductRepo {
	private DataSource dataSource;

	public ProductRepoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "select * from product";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("company"),
						rs.getInt("price"),
						rs.getString("description")
						));
			}
		} finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return list;
	}

	@Override
	public Product select(String id) throws SQLException {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from product where id = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Product(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("company"),
						rs.getInt("price"),
						rs.getString("description")
						);
			}
			
		} finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return null;
	}

	@Override
	public int insert(Product product) throws SQLException {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into product values(?,?,?,?,?)";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getCompany());
			pstmt.setInt(4, product.getPrice());
			pstmt.setString(5, product.getDescription());
			
			return pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
		
	}

	@Override
	public int update(Product product)throws SQLException {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "update product set name=?, company=?, price=?, description=? where id =? ";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getCompany());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getId());
			
			return pstmt.executeUpdate();
			
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
	}

	@Override
	public int delete(String id) throws SQLException {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "delete from product where id = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			
			return pstmt.executeUpdate();
			
			
		} finally {
			DBUtil.close(conn,pstmt);
		}
	}

}

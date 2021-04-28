package com.ssafy.product.model.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;

public interface ProductDao {

	public void insertProduct(Connection conn,Product productDto) throws SQLException;
	public int getLastNo(Connection conn) throws SQLException;
	public Product getProduct(int productno) throws SQLException;
	public int totalCount(Connection conn, PageBean bean) throws SQLException;
	public List<Product> searchAll(Connection conn, PageBean bean) throws SQLException;
}

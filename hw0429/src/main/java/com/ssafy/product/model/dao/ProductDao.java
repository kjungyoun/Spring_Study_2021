package com.ssafy.product.model.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;

@Mapper
public interface ProductDao {

	public void insertProduct(Product productDto) throws SQLException;
	public int getLastNo() throws SQLException;
	public Product getProduct(int productno) throws SQLException;
	public int totalCount(PageBean bean) throws SQLException;
	public List<Product> searchAll(PageBean bean) throws SQLException;
}

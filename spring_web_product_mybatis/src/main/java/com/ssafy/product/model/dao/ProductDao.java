package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;

@Mapper
public interface ProductDao {
	public void insertProduct(Product productDto) ;
	public int getLastNo() ;
	public Product getProduct(int productno) ;
	public int totalCount(PageBean bean);
	public List<Product> searchAll(PageBean bean);
}

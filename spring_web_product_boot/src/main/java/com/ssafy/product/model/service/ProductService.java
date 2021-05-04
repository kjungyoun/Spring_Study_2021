package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;


public interface ProductService {
	public int insertProduct(Product productDto);
	public Product getProduct(int productno);
	public List<Product> searchAll(PageBean bean);
}

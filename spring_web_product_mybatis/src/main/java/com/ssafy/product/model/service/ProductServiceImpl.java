package com.ssafy.product.model.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;

import com.ssafy.product.util.PageUtility;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	
	@Transactional
	@Override
	public int insertProduct(Product productDto) {
			dao.insertProduct(productDto);
			return dao.getLastNo();
	}

	@Transactional
	public Product getProduct(int productno) {
			return dao.getProduct(productno);
	}
	
	@Transactional
	public List<Product> searchAll(PageBean bean) {
			int total =  dao.totalCount(bean);
			PageUtility util = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPageLink(util.getPageBar());
			return dao.searchAll(bean);
		
	}
	
}









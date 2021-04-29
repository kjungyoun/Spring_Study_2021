package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductException;
import com.ssafy.product.util.PageUtility;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	@Transactional
	@Override
	public int insertProduct(Product productDto) {
		try {
			dao.insertProduct(productDto);
			return dao.getLastNo();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 등록 중 오류 발생");
		} 
	}
	
	@Transactional
	@Override
	public Product getProduct(int productno) {
		try {
			return dao.getProduct(productno);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 정보 조회 중 오류 발생");
		}
	}
	
	@Transactional
	@Override
	public List<Product> searchAll(PageBean bean) {
		try {
			//페이징 처리를 위해 전체 데이타 개수 조회
			int total =  dao.totalCount(bean);
			PageUtility util = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPageLink(util.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 목록 조회 중 오류 발생");
		} 
	}
	
}









package com.ssafy.product.model.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.PageBean;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductException;
import com.ssafy.product.util.DBUtil;
import com.ssafy.product.util.PageUtility;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	
	@Override
	public int insertProduct(Product productDto) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			dao.insertProduct(conn, productDto);
			return dao.getLastNo(conn);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
			throw new ProductException("제품 등록 중 오류 발생");
		} finally {
			try {conn.commit();}catch (Exception e) {}
			DBUtil.close(conn);
		}
	}

	public Product getProduct(int productno) {
		try {
			return dao.getProduct(productno);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 정보 조회 중 오류 발생");
		}
	}

	public List<Product> searchAll(PageBean bean) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//페이징 처리를 위해 전체 데이타 개수 조회
			int total =  dao.totalCount(conn, bean);
			PageUtility util = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPageLink(util.getPageBar());
			
			return dao.searchAll(conn, bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 목록 조회 중 오류 발생");
		} finally {
			DBUtil.close(conn);
		}
	}
	
}









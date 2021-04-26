package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;

	public ProductServiceImpl(ProductRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Product> selectAll() throws Exception {
		
		return repo.selectAll();
	}

	@Override
	public Product select(String id)throws Exception {
		id = id == null ? "": id;
		return repo.select(id);
	}

	@Override
	public int insert(Product product) throws Exception{
		
		return repo.insert(product);
	}

	@Override
	public int update(Product product)throws Exception {
		return repo.update(product);
	}

	@Override
	public int delete(String id) throws Exception{
		id = id == null ? "" : id;
		return repo.delete(id);
	}

}

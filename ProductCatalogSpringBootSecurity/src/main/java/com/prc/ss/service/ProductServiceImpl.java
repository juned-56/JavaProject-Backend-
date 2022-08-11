package com.prc.ss.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prc.ss.model.Product;
import com.prc.ss.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addNewProduct(Product prd) {
		return productRepository.save(prd);
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public Iterable<Product> getAllProduts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductDetailsById(int id) {
		return productRepository.findById(id);
	}
	
	

}

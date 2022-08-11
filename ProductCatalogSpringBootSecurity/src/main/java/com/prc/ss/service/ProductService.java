package com.prc.ss.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.prc.ss.model.Product;


@Service
@Transactional
public interface ProductService {

	public Product addNewProduct(Product prd);
	public void deleteProductById(int id);
	public Iterable<Product> getAllProduts();
	public Optional<Product> getProductDetailsById(int id);
}

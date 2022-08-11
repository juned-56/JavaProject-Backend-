package com.prc.ss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prc.ss.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findByBrandContaining(String brnd);
	public List<Product> findByPrcodeContaining(String prcode);
	public List<Product> findByPrnameContaining(String prname);
	public List<Product> findByBrandOrPrcodeOrPrname(String brnd, String prcode, String prname);
	//public List<Product> findByPrpincodeContaining(String prpincode);
}

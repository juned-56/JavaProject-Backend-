package com.prc.ss.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prc.ss.model.Address;
import com.prc.ss.model.Product;
import com.prc.ss.model.User;
import com.prc.ss.repository.ProductRepository;
import com.prc.ss.repository.UserRepository;
import com.prc.ss.service.AddressService;
import com.prc.ss.service.ProductService;
import com.prc.ss.service.UserService;



@RestController
@RequestMapping("/auth/v1")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressService addressService;
	
	
	
	
	/*
	 * @User Controller Start
	 */
	
	@PostMapping("/addUser")   //url : http://localhost:8181/auth/v1/addUser
	public User addNewUser(@RequestBody User usr) {
		return userService.addNewUser(usr);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")   //url : http://localhost:8181/auth/v1//deleteUser/{id}
	public void deleteById(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
	
	/*
	 * @User Controller End
	 */
	
	
	
	/*
	 * @Address Controller
	 */
	
	@PostMapping("/address")    // Url  http://localhost:8181/auth/v1/address
	public Address addNewAddress(@RequestBody Address ards) {
		return addressService.addAddress(ards);
	}
	
	
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestBody Address ardss) {
		return addressService.UpdateAddress(ardss);
	}
	
	
	@GetMapping("/getAddressById/{id}")
	public Optional<Address> getAddressById(@PathVariable("id") int id) {
		return addressService.getAddressById(id);
	}
	
	
	@GetMapping("/getAllAddress")
	public Iterable<Address> getAllAddress() {
		return addressService.getAllAddress();
	}
	
	
	@DeleteMapping("/deleteaddressById/{id}")
	public void deleteAddressById(@PathVariable("id") int id) {
		addressService.deleteAddressById(id);
	}
	/*
	 * @Address Controller End
	 */
	
	
	/*
	 * @Product Controller Start
	 */
	
	@PostMapping("/addProduct")
	public Product addNewProduct(@RequestBody Product prd) {
		return productService.addNewProduct(prd);
	}
	
	@GetMapping("/getAllProduct")
	public Iterable<Product> getAllProduct() {
		return productService.getAllProduts();
	}
	
	@GetMapping("/getProductDetailByid/{id}")
	public Optional<Product> getProductDetailsById(@PathVariable("id") int id){
		return productService.getProductDetailsById(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteByIdd(@PathVariable("id") int id) {
		productService.deleteProductById(id);
	}
	
	
	
	@GetMapping("/products/brnd")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String brand){
		List<Product> prdts = new ArrayList<Product>();
		if(brand == null) 
			productRepository.findAll().forEach(prdts::add);
		else
			productRepository.findByBrandContaining(brand).forEach(prdts::add);
		if (prdts.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(prdts, HttpStatus.OK);
	}
	
	
	@GetMapping("/product/prcde")
	public ResponseEntity<List<Product>> getProductByProductCode(@RequestParam(required = false) String prcode){
		List<Product> prdts1 = new ArrayList<Product>();
		if(prcode == null)
			productRepository.findAll().forEach(prdts1::add);
		else
			productRepository.findByPrcodeContaining(prcode).forEach(prdts1::add);
		if (prcode.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(prdts1, HttpStatus.OK);
	}
	
	@GetMapping("/product/prnme")
	public ResponseEntity<List<Product>> getProductByProductName(@RequestParam(required = false) String prname){
		List<Product> prdts2 = new ArrayList<Product>();
		if(prname == null)
			productRepository.findAll().forEach(prdts2::add);
		else
			productRepository.findByPrnameContaining(prname).forEach(prdts2::add);
		if(prdts2.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(prdts2, HttpStatus.OK);
	}
	
	@GetMapping("/product/brndOrprcdeOrprnme")
	public ResponseEntity<List<Product>> getProductByBrandOrProductCodeOrProductName(@RequestParam(required = false) String brand, String prcode, String prname){
		return new ResponseEntity<List<Product>>(productRepository.findByBrandOrPrcodeOrPrname(brand, prcode, prname), HttpStatus.OK);
	}
	
//	@GetMapping("/product/develeryBypincode")
//	public ResponseEntity<List<Product>> getProductAbility(@RequestParam(required = false) String prpincode){
//		List<Product> prdct3 = new ArrayList<Product>();
//		if(prpincode == null)
//			productRepository.findAll().forEach(prdct3::add);
//		else
//			productRepository.findByPrpincodeContaining(prpincode).forEach(prdct3::add);
//		if(prdct3.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			
//		}
//		return new ResponseEntity<>(prdct3, HttpStatus.OK);
//		
//	}
	
	
	
	/*
	 * @Product Controller End
	 */
}


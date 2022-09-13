package com.product.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.services.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/addProduct")
	public Integer addProduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);

		System.out.println(id);

		return id;
	}

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product, id);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) {
		System.out.println(id);
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(HttpStatus.OK);
		try {
			productService.deleteProduct(id);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		return responseEntity;

	}
}

package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable Integer id){
		return  productService.getProduct(id);
	}

}

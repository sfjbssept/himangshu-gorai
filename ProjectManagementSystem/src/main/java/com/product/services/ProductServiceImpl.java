package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repo.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Integer addProduct(Product product) {
		Product addedProduct = productRepository.save(product);
		return addedProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

}

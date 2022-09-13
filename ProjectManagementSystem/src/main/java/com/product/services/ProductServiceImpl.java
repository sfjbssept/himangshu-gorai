package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ResourceNoFoundException;
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

	@Override
	public Product updateProduct(Product product, Integer id) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNoFoundException("Product", "id", id));

		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductCategory(product.getProductCategory());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductPrice(product.getProductPrice());

		productRepository.save(existingProduct);

		return existingProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		try {
			productRepository.deleteById(id);
		} catch (IllegalArgumentException ex) {
			throw ex;
		}

	}

}

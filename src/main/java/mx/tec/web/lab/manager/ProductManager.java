/*
 * ProductManager
 * Version 1.0
 * August 14, 2021 
 * Copyright 2021 Tecnologico de Monterrey
 */
package mx.tec.web.lab.manager;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import mx.tec.web.lab.entity.Product;
import mx.tec.web.lab.entity.Sku;
import mx.tec.web.lab.repository.ProductRepository;

/**
 * The Product Manager with all the available business operations for the products
 * @author eddy
 * @version 1.0
 */
@Service
public class ProductManager {
	@Resource
	ProductRepository productRepository;
	
	/**
	 * Method to retrieve all the products in the product repository
	 * @return returns a list of products in the product repository
	 */
	public List<Product> getProducts() {
		return productRepository.findAll(); 
	} 
	
	/**
	 * Method to get an existing product with the id
	 * @param id to search the product
	 * @return returns an optional of the product that has the id
	 */
	public Optional<Product> getProduct(final long id) {
		Optional<Product> foundProduct = productRepository.findById(id);
		
		return foundProduct; 
	} 
	
	/**
	 * Method to add a new product to the product repository
	 * @param newProduct to add to the product repository
	 * @return returns the product that has been saved to the product repository
	 */
	public Product addProduct(final Product newProduct) {
		for( final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		Product savedProduct = productRepository.save(newProduct);
		return savedProduct; 
	} 
	
	/**
	 * Method to update an existing product
	 * @param id used to search the product in the product repository
	 * @param modifiedProduct product to be updated
	 */
	public void updateProduct(final long id, final Product modifiedProduct) {
		if(modifiedProduct.getId() == id) {
			for (final Sku modifiedSku : modifiedProduct.getChildSkus()) {
				modifiedSku.setParentProduct(modifiedProduct);
			}
			productRepository.save(modifiedProduct);
		}
	}
	
	/**
	 * Method to delete a product from the product repository
	 * @param existingProduct used to delete the product provided
	 */
	public void deleteProduct(final Product existingProduct) {
			productRepository.delete(existingProduct);
	}
	
	/**
	 * Method to get the products that match the pattern provided
	 * @param pattern used to search
	 * @return returns a list of products that contains in their name the pattern provided.
	 */
	public List<mx.tec.web.lab.entity.Product> getProducts(final String pattern) { 
		return productRepository.findByNameLike(pattern); 
		} 

}

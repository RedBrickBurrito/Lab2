/**
 * 
 */
package mx.tec.web.lab.manager;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.tec.web.entity.Product;

import javax.annotation.Resource;
import mx.tec.web.lab.repository.ProductRepository;

/**
 * @author eddy
 *
 */
@Service
public class ProductManager {
	@Resource
	ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll(); 
	} 
//	
	public Optional<Product> getProduct(final long id) {
		Optional<Product> foundProduct = productRepository.findById(id);
		
		return foundProduct; 
	} 
	
//	public Optional<Product> addProducts(final Product newProduct) {
//		products.add(newProduct);
//		return Optional.of(newProduct); 
//	} 
//	
//	public Optional<Product> modifyProduct(final String id, final Product newProduct) {
//		Optional<Product> modifiedProduct = Optional.empty();
//		
//		for(final Product product : products) {
//			if (product.getId().equals(id)) {
//				product.setDescription(newProduct.getDescription());
//				product.setChildSkus(newProduct.getChildSkus());
//				product.setLargeImageUrl(newProduct.getLargeImageUrl());
//				product.setMediumImageUrl(newProduct.getMediumImageUrl());
//				product.setSmallImageUrl(newProduct.getSmallImageUrl());
//				product.setName(newProduct.getName());
//				modifiedProduct = Optional.of(product);
//				break; 
//			}
//		}
//		
//		return modifiedProduct; 
//	} 
//	
//	public Optional<Product> deleteProduct(final String id) {
//		Optional<Product> foundProduct = Optional.empty();
//		
//		for (Product product : products) {
//			if (product.getId().equals(id)) {
//				products.remove(product);
//				foundProduct = Optional.of(product);
//				break; 
//			}
//		}
//		
//		return foundProduct; 
//	} 

}

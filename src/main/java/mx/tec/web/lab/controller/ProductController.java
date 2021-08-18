/**
 * 
 */
package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.entity.Product;
import mx.tec.web.lab.manager.ProductManager;

/**
 * @author eddy
 *
 */
@RestController
public class ProductController {
	@Resource
	private ProductManager productManager;
	
	@GetMapping("/products") 
	public ResponseEntity<List<Product>> getProducts() { 
		List<Product> products = productManager.getProducts(); 
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.OK); 
		return responseEntity; 
	}

	@GetMapping("/products/{id}") 
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) { 
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		Optional<Product> product = productManager.getProduct(id);
		if (product.isPresent()) { 
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK); 
			} 
		return responseEntity; 
	} 
//	
//	@PostMapping("/products") 
//	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) { 
//		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
//		System.out.println("newProduct.id " + newProduct.getId()); 
//		Optional<Product> product = productManager.addProducts(newProduct); 
//		if (product.isPresent()) { 
//			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.CREATED); 
//			} 
//		return responseEntity; 
//		} 
//	
//	@PutMapping("/products/{id}")
//	public ResponseEntity<Product> modifyProduct(@PathVariable(value = "id") String id, @RequestBody Product newProduct) { 
//		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
//		Optional<Product> product = productManager.modifyProduct(id, newProduct); 
//		if (product.isPresent()) { 
//			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK); 
//		} 
//		return responseEntity; 
//	}
//	
//	@DeleteMapping("/products/{id}")
//	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") String id) { 
//		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
//		Optional<Product> product = productManager.deleteProduct(id);
//		if (product.isPresent()) { 
//			responseEntity = new ResponseEntity<>(HttpStatus.OK); 
//		} 
//		return responseEntity; 
//	} 
	
}

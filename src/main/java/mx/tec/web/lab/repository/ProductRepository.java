package mx.tec.web.lab.repository; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.tec.web.lab.entity.Product;

/*
 * Product Repository Interface to query products
 * @author eddy
 * @version 1.0
 */
@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * find product with pattern
	 * @param pattern to search
	 * @return the list of products that has the pattern
	 */
	@Query("FROM Product WHERE name LIKE %:pattern%")	
	List<Product> findByNameLike(@Param("pattern") String pattern);

}
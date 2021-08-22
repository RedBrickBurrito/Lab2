package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Product Value Object to store the product attributtes
 * 
 * @author eddy
 * @version 1.0
 */
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1940424686731950240L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	private List<Sku> childSkus;

	/**
	 * No arguments constructor
	 */
	public Product() {
	}

	/**
	 * Constructor including all the properties
	 * 
	 * @param id          Product id
	 * @param name        Product name
	 * @param description Product description
	 * @param childSkus   List of Product Skus
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}

	/**
	 * Get product id
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the product id
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the product name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the product name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the product description 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the product description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the product childSkus
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}

	/**
	 * Set the product childSkus
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}
	
	/**
	 * Transform all product attributes to string
	 * @return the product with attributes in a string
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}
	
	/**
	 * Hash the id
	 * @return the objects hash
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Compare id object with another
	 * @param obj to compare
	 * @return if the two products are equal or not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

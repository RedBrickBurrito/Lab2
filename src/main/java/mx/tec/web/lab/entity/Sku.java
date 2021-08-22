package mx.tec.web.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Sku Value Object to store the SKU attributtes
 * 
 * @author eddy
 * @version 1.0
 */
@Entity
public class Sku implements Serializable {
	private static final long serialVersionUID = -6185764898853598449L;
	@Id
	@GeneratedValue
	private long id;
	private String color;
	private String size;
	private double listPrice;
	private double salePrice;
	private long quantityOnHand;
	private String smallImageUrl;
	private String mediumImageUrl;
	private String largeImageUrl;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product parentProduct;

	/**
	 * No arguments constructor
	 */
	public Sku() {
	}

	/**
	 * Constructor including all the properties
	 * 
	 * @since 2.0
	 * @param id             Sku id
	 * @param color          Sku color
	 * @param size           Sku size
	 * @param listPrice      The list price
	 * @param salePrice      The sale price
	 * @param quantityOnHand The quantity on hand
	 * @param smallImageUrl  The small Image URL
	 * @param mediumImageUrl The medium Image URL
	 * @param largeImageUrl  The large Image URL
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, long quantityOnHand,
			String smallImageUrl, String mediumImageUrl, String largeImageUrl) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImageUrl = smallImageUrl;
		this.mediumImageUrl = mediumImageUrl;
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * Get the sku id
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the sku id
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the sku color
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set the sku color
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get the sku size
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Set the sku size
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Get the sku listPrice
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}

	/**
	 * Set the sku listPrice
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * Get the sku salePrice
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * Set the sku salePrice
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * Get the sku quantityOnHand
	 * @return the quantityOnHand
	 */
	public long getQuantityOnHand() {
		return quantityOnHand;
	}

	/**
	 * Set the sku quantityOnHand
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	/**
	 * Get the sku small image url
	 * @return the smallImageUrl
	 */
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	/**
	 * Set the sku small image url
	 * @param smallImageUrl the smallImageUrl to set
	 */
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	/**
	 * Get the sku medium image url
	 * @return the mediumImageUrl
	 */
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}

	/**
	 * Set the sku medium image url
	 * @param mediumImageUrl the mediumImageUrl to set
	 */
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}

	/**
	 * Get the sku large image url
	 * @return the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * Set the sku large image url
	 * @param largeImageUrl the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * Get the sku parentProduct
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}

	/**
	 * Set the sku parentProduct
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}
	
	/**
	 * Transform all sku attributes to string
	 * @return the sku with attributes in a string
	 */
	@Override
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImageUrl=" + smallImageUrl
				+ ", mediumImageUrl=" + mediumImageUrl + ", largeImageUrl=" + largeImageUrl + ", parentProduct="
				+ parentProduct + "]";
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sku)) {
			return false;
		}
		Sku other = (Sku) obj;
		return id == other.id;
	}
	
	

}

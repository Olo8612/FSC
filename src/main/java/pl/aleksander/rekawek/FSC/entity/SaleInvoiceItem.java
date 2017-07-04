package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="saleItems")
public class SaleInvoiceItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String typeOfWood;
	@NotNull
	private String productType;
	
	private Integer dimension;
	
	@NotNull
	@Column(name="quantCapacity")
	private Long quantityCm3;
	
	@NotNull
	@Column(name="quantWeight")
	private Long quantityGrams;
	
	@NotNull
	private Long quantity;
	@NotNull
	private Long priceNet;
	
	public SaleInvoiceItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeOfWood() {
		return typeOfWood;
	}

	public void setTypeOfWood(String typeOfWood) {
		this.typeOfWood = typeOfWood;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public Long getQuantityCm3() {
		return quantityCm3;
	}

	public void setQuantityCm3(Long quantityCm3) {
		this.quantityCm3 = quantityCm3;
	}

	public Long getQuantityGrams() {
		return quantityGrams;
	}

	public void setQuantityGrams(Long quantityGrams) {
		this.quantityGrams = quantityGrams;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(Long priceNet) {
		this.priceNet = priceNet;
	}
	
	
}

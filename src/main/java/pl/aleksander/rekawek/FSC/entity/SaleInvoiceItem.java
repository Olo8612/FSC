package pl.aleksander.rekawek.FSC.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "saleItems")
public class SaleInvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String typeOfWood;

	@NotNull
	private String productType;

	private Integer dimension;

	@NotNull
	@Column(name = "quantCapacity")
	private Long quantityPiece;

	@NotNull
	@Column(name = "quantWeight")
	private Long quantityGrams;

	@NotNull
	private BigDecimal priceNet;
	
	@ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name="invoice.id")
	private SaleInvoice saleInvoice;

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

	public Long getQuantityPiece() {
		return quantityPiece;
	}

	public void setQuantityPiece(Long quantityPiece) {
		this.quantityPiece = quantityPiece;
	}

	public Long getQuantityGrams() {
		return quantityGrams;
	}

	public void setQuantityGrams(Long quantityGrams) {
		this.quantityGrams = quantityGrams;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(BigDecimal priceNet) {
		this.priceNet = priceNet;
	}

}

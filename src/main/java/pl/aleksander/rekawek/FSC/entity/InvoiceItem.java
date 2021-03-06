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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "invoiceItems")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String description;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private WoodType woodType;

	@NotNull
	@Column(name = "quantCapacity")
	private Long quantityCm3;

	@NotNull
	@Column(name = "quantWeight")
	private Long quantityGrams;

	@NotNull
	@Column(name = "fsc")
	private Integer fscCategory;

	@ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name="invoice.id")
	private Invoice invoice;

	@NotNull
	private BigDecimal priceNet;

	public InvoiceItem() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WoodType getWoodType() {
		return woodType;
	}

	public void setWoodType(WoodType woodType) {
		this.woodType = woodType;
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

	public Integer getFscCategory() {
		return fscCategory;
	}

	public void setFscCategory(Integer fscCategory) {
		this.fscCategory = fscCategory;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public BigDecimal getPriceNet() {
		return priceNet;
	}

	public void setPriceNet(BigDecimal priceNet) {
		this.priceNet = priceNet;
	}

}

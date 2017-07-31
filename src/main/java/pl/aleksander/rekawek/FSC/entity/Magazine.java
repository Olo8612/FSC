package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Entity for actual status of magazine
 */
@Entity
@Table(name = "magazine")
public class Magazine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantWeight")
	private Long quantityGrams;

	@Column(name = "quantCapacity")
	private Long quantityCm3;

	@Column(name = "fsc")
	private Integer fscCategory;

	@OneToOne(fetch = FetchType.EAGER)
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.EAGER)
	private WoodType woodType;

	public Magazine() {

	}

	public WoodType getWoodType() {
		return woodType;
	}

	public void setWoodType(WoodType woodType) {
		this.woodType = woodType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantityGrams() {
		return quantityGrams;
	}

	public void setQuantityGrams(Long quantityGrams) {
		this.quantityGrams = quantityGrams;
	}

	public Long getQuantityCm3() {
		return quantityCm3;
	}

	public void setQuantityCm3(Long quantityCm3) {
		this.quantityCm3 = quantityCm3;
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

}

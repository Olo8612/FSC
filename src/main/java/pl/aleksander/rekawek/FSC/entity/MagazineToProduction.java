package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "magazineProduction")
public class MagazineToProduction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "quantCapacity")
	private Long quantityCm3;

	@NotNull
	@Column(name = "quantWeight")
	private Long quantityGrams;

	@NotNull
	@Column(name = "fsc")
	private Integer fscCategory;

	public MagazineToProduction() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}

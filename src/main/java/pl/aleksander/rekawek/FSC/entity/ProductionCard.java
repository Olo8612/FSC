package pl.aleksander.rekawek.FSC.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="productionCard")
public class ProductionCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date date;
	
	@NotNull
	@OneToOne
	private MagazineToProduction magazineGetWood;
	
	@NotNull
	@OneToMany
	private List<FscSale> sale;

	public ProductionCard() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MagazineToProduction getMagazineGetWood() {
		return magazineGetWood;
	}

	public void setMagazineGetWood(MagazineToProduction magazineGetWood) {
		this.magazineGetWood = magazineGetWood;
	}

	public List<FscSale> getSale() {
		return sale;
	}

	public void setSale(List<FscSale> sale) {
		this.sale = sale;
	}
	
	
}

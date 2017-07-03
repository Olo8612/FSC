package pl.aleksander.rekawek.FSC.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name="magazineStuff")
	private MagazineToProduction magazineGetWood;
	
	@NotNull
	private FscSale sale;

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

	public FscSale getSale() {
		return sale;
	}

	public void setSale(FscSale sale) {
		this.sale = sale;
	}
	
	
}

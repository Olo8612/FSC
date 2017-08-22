package pl.aleksander.rekawek.FSC.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productionCard")
public class ProductionCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Timestamp date;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private MagazineToProduction magazineGetWood;

	@NotNull
	@OneToMany
	private List<SaleInvoice> sale;

	public ProductionCard() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public MagazineToProduction getMagazineGetWood() {
		return magazineGetWood;
	}

	public void setMagazineGetWood(MagazineToProduction magazineGetWood) {
		this.magazineGetWood = magazineGetWood;
	}

	public List<SaleInvoice> getSale() {
		return sale;
	}

	public void setSale(List<SaleInvoice> sale) {
		this.sale = sale;
	}

}

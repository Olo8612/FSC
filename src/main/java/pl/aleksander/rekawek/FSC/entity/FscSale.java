package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fscSale")
public class FscSale {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private SaleInvoice invoice;

	public FscSale() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SaleInvoice getInvoice() {
		return invoice;
	}

	public void setInvoice(SaleInvoice invoice) {
		this.invoice = invoice;
	}
	
	
	
}

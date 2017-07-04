package pl.aleksander.rekawek.FSC.entity;

import java.util.List;

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
	private List<SaleInvoice> invoice;

	public FscSale() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SaleInvoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<SaleInvoice> invoice) {
		this.invoice = invoice;
	}
	
	
	
}

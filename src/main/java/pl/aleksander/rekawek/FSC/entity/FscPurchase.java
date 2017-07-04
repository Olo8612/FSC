package pl.aleksander.rekawek.FSC.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fscPurchase")
public class FscPurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Date month;

	/*
	 * Mapped with invoiceNumber Comment TO-DELETE
	 */
	@OneToOne
	private Invoice invoiceItems;

	public FscPurchase() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public Invoice getInvoiceItem() {
		return invoiceItems;
	}

	public void setInvoiceItem(Invoice invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

}

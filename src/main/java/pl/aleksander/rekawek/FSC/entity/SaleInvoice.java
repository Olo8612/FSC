package pl.aleksander.rekawek.FSC.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="saleInvoice")
public class SaleInvoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name="number")
	private String invoiceNumber;
	
	@NotNull
	private Date dateOfIssue;
	
	@NotNull
	private Date dateOfPayment;
	
	@NotNull
	@ManyToOne
	private Customer customer;
	
	@NotNull
	@OneToMany
	private List<SaleInvoiceItem> items;
	
	@NotNull
	private Long invoiceValueNet;

	public SaleInvoice() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<SaleInvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<SaleInvoiceItem> items) {
		this.items = items;
	}

	public Long getInvoiceValueNet() {
		return invoiceValueNet;
	}

	public void setInvoiceValueNet(Long invoiceValueNet) {
		this.invoiceValueNet = invoiceValueNet;
	}
	
	
	
}

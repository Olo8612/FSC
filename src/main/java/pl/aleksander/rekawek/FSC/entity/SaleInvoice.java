package pl.aleksander.rekawek.FSC.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "saleInvoice")
public class SaleInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "number")
	private String invoiceNumber;

	@NotNull
	private Timestamp dateOfIssue;

	@NotNull
	private Timestamp dateOfPayment;

	@NotNull
	@ManyToOne
	private Customer customer;

	@NotNull
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "saleInvoice")
	private List<SaleInvoiceItem> items;

	@NotNull
	@Column(name = "value")
	private BigDecimal invoiceValueNet;

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

	public Timestamp getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Timestamp dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Timestamp getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Timestamp dateOfPayment) {
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

	public BigDecimal getInvoiceValueNet() {
		return invoiceValueNet;
	}

	public void setInvoiceValueNet(BigDecimal invoiceValueNet) {
		this.invoiceValueNet = invoiceValueNet;
	}

}

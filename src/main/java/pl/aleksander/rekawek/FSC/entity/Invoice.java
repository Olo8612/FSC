package pl.aleksander.rekawek.FSC.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "issue")
	private Date dateOfIssue;

	@NotNull
	@Column(name = "payment")
	private Date dateOfPayment;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<InvoiceItems> items;
	
	@Column(name="value")
	private BigDecimal valueOfAllNet;

	public Invoice() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<InvoiceItems> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItems> items) {
		this.items = items;
	}

	public BigDecimal getValueOfAllNet() {
		return valueOfAllNet;
	}

	public void setValueOfAllNet(BigDecimal valueOfAllNet) {
		this.valueOfAllNet = valueOfAllNet;
	}
	
	
}

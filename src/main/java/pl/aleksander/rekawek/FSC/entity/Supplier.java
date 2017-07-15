package pl.aleksander.rekawek.FSC.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String address;

	@NotNull
	@Min(25)
	@Max(100)
	private Integer fscCategory;

	@NotBlank
	@Column(name = "certCode")
	private String fscCertificationCode;
	
	@NIP
	@Column(name = "taxIndentity")
	private String taxIdentificationNumber;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "verifyDate")
	private Date lastVerificationDate;
	
	@Column(name = "info")
	private String additionalInformations;

	public Supplier() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFscCategory() {
		return fscCategory;
	}

	public void setFscCategory(Integer fscCategory) {
		this.fscCategory = fscCategory;
	}

	public String getFscCertificationCode() {
		return fscCertificationCode;
	}

	public void setFscCertificationCode(String fscCertificationCode) {
		this.fscCertificationCode = fscCertificationCode;
	}

	public Date getLastVerificationDate() {
		return lastVerificationDate;
	}

	public void setLastVerificationDate(Date lastVerificationDate) {
		this.lastVerificationDate = lastVerificationDate;
	}

	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}

	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}

	public String getAdditionalInformations() {
		return additionalInformations;
	}

	public void setAdditionalInformations(String additionalInformations) {
		this.additionalInformations = additionalInformations;
	}

}

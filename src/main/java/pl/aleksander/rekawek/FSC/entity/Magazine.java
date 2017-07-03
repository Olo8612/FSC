package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * Entity for actual status of magazine
 */
@Entity
@Table(name="magazine")
public class Magazine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="quantWeight")
	private Long quantityGrams;
	
	@NotNull
	@Column(name="quantCapacity")
	private Long quantityCm3;
	
	@NotNull
	@Column(name="fsc")
	private Integer fscCategory;
	
	@OneToOne
	private Invoice invoiceNumber;
}

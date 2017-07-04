package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaleToProductionCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
}

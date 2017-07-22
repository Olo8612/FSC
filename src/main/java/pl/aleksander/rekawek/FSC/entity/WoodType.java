package pl.aleksander.rekawek.FSC.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class WoodType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private Long efficiencyKnots;

	@NotNull
	private Long efficiencyBoats;

	public WoodType() {
	
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

	public Long getEfficiencyKnots() {
		return efficiencyKnots;
	}

	public void setEfficiencyKnots(Long efficiencyKnots) {
		this.efficiencyKnots = efficiencyKnots;
	}

	public Long getEfficiencyBoats() {
		return efficiencyBoats;
	}

	public void setEfficiencyBoats(Long efficiencyBoats) {
		this.efficiencyBoats = efficiencyBoats;
	}

	
}

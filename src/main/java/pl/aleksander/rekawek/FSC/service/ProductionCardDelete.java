package pl.aleksander.rekawek.FSC.service;

import pl.aleksander.rekawek.FSC.entity.Magazine;
import pl.aleksander.rekawek.FSC.entity.ProductionCard;

public class ProductionCardDelete {

	private ProductionCard card;

	public ProductionCardDelete(ProductionCard card) {
		this.card = card;
	}
	
	public Magazine restoreMagazinePositions(){
		Magazine toReturn = this.card.getMagazineGetWood().getMagazine();
		toReturn.setQuantityCm3(toReturn.getQuantityGrams()+this.card.getMagazineGetWood().getQuantityCm3());
		toReturn.setQuantityGrams(toReturn.getQuantityGrams()+this.card.getMagazineGetWood().getQuantityGrams());
		return toReturn;
	}

}

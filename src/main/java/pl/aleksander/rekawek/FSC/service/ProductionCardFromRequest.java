package pl.aleksander.rekawek.FSC.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import pl.aleksander.rekawek.FSC.entity.Magazine;
import pl.aleksander.rekawek.FSC.entity.MagazineToProduction;
import pl.aleksander.rekawek.FSC.entity.ProductionCard;

public class ProductionCardFromRequest {
	
	private final String TIME_ADD = " 00:00:00";
	private ProductionCard card;
	private Magazine magazine;
	private MagazineToProduction mProduction;

	public ProductionCardFromRequest(Magazine magazine) {
		this.magazine = magazine;
	}

	public void createProductionCardFromRequestParams(HttpServletRequest request)
			throws NumberFormatException, IllegalArgumentException {
		this.card = new ProductionCard();
		
		Long quantityCm;
		Long quantityGrams;
		
		Double tempCm = Double.parseDouble(request.getParameter("ndtrimetrs"))*100.0;
		Double tempGrams = Double.parseDouble(request.getParameter("ndkg"))*1000.0;
		
		quantityCm = tempCm.longValue();
		quantityGrams = tempGrams.longValue();
		this.card.setDate(Timestamp.valueOf(request.getParameter("date")+TIME_ADD));

		this.mProduction = getWoodFromMagazine(quantityCm, quantityGrams);
		this.card.setMagazineGetWood(mProduction);

	}

	public MagazineToProduction getWoodFromMagazine(Long quantityCm, Long quantityGrams) {
		MagazineToProduction toProduction = new MagazineToProduction();
		toProduction.setMagazine(this.magazine);
		if (this.magazine.getQuantityCm3() >= quantityCm && this.magazine.getQuantityGrams() >= quantityGrams) {
			toProduction.setQuantityCm3(quantityCm);
			toProduction.setQuantityGrams(quantityGrams);

			this.magazine.setQuantityCm3(this.magazine.getQuantityCm3() - quantityCm);
			this.magazine.setQuantityGrams(this.magazine.getQuantityGrams() - quantityGrams);
		} else if (this.magazine.getQuantityCm3() == 0) {
			return null;
		} else {
			toProduction.setQuantityCm3(this.magazine.getQuantityCm3());
			toProduction.setQuantityGrams(this.magazine.getQuantityGrams());

			this.magazine.setQuantityCm3(0L);
			this.magazine.setQuantityGrams(0L);
		}
		return toProduction;

	}

	public ProductionCard getCard() {
		return card;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public MagazineToProduction getmProduction() {
		return mProduction;
	}

}

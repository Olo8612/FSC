package pl.aleksander.rekawek.FSC.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import pl.aleksander.rekawek.FSC.entity.SaleInvoiceItem;
import pl.aleksander.rekawek.FSC.entity.WoodType;

public class SaleInvoiceItemsFromRequest {

	public static SaleInvoiceItem getSaleItemFromRequest(HttpServletRequest request, WoodType type)
			throws IllegalArgumentException, NumberFormatException {
		SaleInvoiceItem item = new SaleInvoiceItem();
		Double tempGrams = Double.parseDouble(request.getParameter("quantityGrams"))*1000.0;
		item.setProductType(request.getParameter("productType"));
		item.setDimension(Integer.parseInt(request.getParameter("dimension")));
		item.setWoodType(type);
		item.setQuantityPiece(Long.parseLong(request.getParameter("quantityPiece")));
		item.setQuantityGrams(tempGrams.longValue());
		item.setFscCategory(Integer.parseInt(request.getParameter("fscCategory")));
		item.setPriceNet(BigDecimal.valueOf(Double.parseDouble(request.getParameter("priceNet"))));
		item.setAdditionalInformation(request.getParameter("addInfo"));

		return item;
	}

}

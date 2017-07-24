package pl.aleksander.rekawek.FSC.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import pl.aleksander.rekawek.FSC.entity.InvoiceItem;

@Component
public class InvoiceItemsFromFormProcess {

	public InvoiceItem createInvoiceItemFromRequest(HttpServletRequest request) {
		InvoiceItem item = new InvoiceItem();
		item.setDescription((String) request.getAttribute("invoiceDescription"));

		item.setFscCategory((Integer) request.getAttribute("invoiceFscCAt"));

//		item.setWoodType((String) request.getParameter("invoiceWoodType"));

		item.setQuantityCm3(((Long) request.getAttribute("invoiceQuantityCm3")) * 100);

		item.setQuantityGrams(((Long) request.getAttribute("invoiceQuantityGrams")) * 100);

		item.setFscCategory((Integer) request.getAttribute("invoiceFscCAt"));

		item.setPriceNet(BigDecimal.valueOf(Double.parseDouble(request.getParameter("invoicePriceNet"))));

		return item;
	}
}

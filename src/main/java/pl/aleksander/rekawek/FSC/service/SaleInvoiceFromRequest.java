package pl.aleksander.rekawek.FSC.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import pl.aleksander.rekawek.FSC.entity.Customer;
import pl.aleksander.rekawek.FSC.entity.SaleInvoice;

public class SaleInvoiceFromRequest {

	private final String TIME_ADD = " 00:00:00";
	private SaleInvoice invoice;
	private Customer customer;
	private HttpServletRequest request;

	public SaleInvoiceFromRequest(HttpServletRequest request, Customer customer) {
		this.request = request;
		this.customer = customer;

	}

	public void createSaleInvoiceFromRequestParams() throws  IllegalArgumentException {
		this.invoice = new SaleInvoice();
		this.invoice.setCustomer(customer);
		this.invoice.setInvoiceNumber(request.getParameter("invoiceNumber"));
		this.invoice.setDateOfIssue(Timestamp.valueOf(request.getParameter("date") + TIME_ADD));
		this.invoice.setDateOfPayment(Timestamp.valueOf(request.getParameter("dateOfPayment") + TIME_ADD));

	}

	public SaleInvoice getInvoice() {
		return invoice;
	}

}

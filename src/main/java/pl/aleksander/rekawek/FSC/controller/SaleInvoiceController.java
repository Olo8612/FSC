package pl.aleksander.rekawek.FSC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.aleksander.rekawek.FSC.entity.Customer;
import pl.aleksander.rekawek.FSC.entity.SaleInvoiceItem;
import pl.aleksander.rekawek.FSC.entity.WoodType;
import pl.aleksander.rekawek.FSC.repository.CustomerRepository;
import pl.aleksander.rekawek.FSC.repository.SaleInvoiceItemRepository;
import pl.aleksander.rekawek.FSC.repository.SaleInvoiceRepository;
import pl.aleksander.rekawek.FSC.repository.WoodTypeRepository;
import pl.aleksander.rekawek.FSC.service.SaleInvoiceFromRequest;
import pl.aleksander.rekawek.FSC.service.SaleInvoiceItemsFromRequest;

@Controller
@RequestMapping(path = "/sale")
public class SaleInvoiceController {

	@Autowired
	private SaleInvoiceItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SaleInvoiceRepository invoiceRepository;

	@Autowired
	private WoodTypeRepository woodTypes;

	@ModelAttribute(name = "woodType")
	public List<WoodType> getAllWoodTypes() {
		return woodTypes.findAll();
	}

	@ModelAttribute(name = "customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getAllSaleInvoices(Model model) {
		model.addAttribute("invoices", invoiceRepository.findAll());
		return "views/saleInvoiceList";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateSaleInvoiceForm(Model model) {
		return "forms/createSaleInvoiceForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateSaleInvoiceForm(HttpServletRequest request, Model model) {
		Customer customer = customerRepository.findOne(Long.parseLong(request.getParameter("customer")));
		SaleInvoiceFromRequest invoice = new SaleInvoiceFromRequest(request, customer);
		try {
			invoice.createSaleInvoiceFromRequestParams();
		} catch (IllegalArgumentException e) {
			model.addAttribute("errors", "Niepoprawny format daty poprawny format to: RRRR-MM-DD");
			return "forms/createSaleInvoiceForm";
		}
		invoiceRepository.save(invoice.getInvoice());
		return "redirect: ./add/" + invoice.getInvoice().getId() + "/items";
	}

	@RequestMapping(path = "/add/{id}/items", method = RequestMethod.GET)
	public String getSaleInvoiceItemsForm(Model model, @PathVariable Long id) {

		model.addAttribute("invoice", invoiceRepository.findOne(id));
		model.addAttribute("items", itemRepository.findAllSaleInvoiceItemsBySaleInvoiceId(id));
		return "forms/addSaleInvoiceItemForm";
	}

	@RequestMapping(path = "/add/{id}/items", method = RequestMethod.POST)
	public String processSaleInvoiceItemsForm(HttpServletRequest request, Model model) {
		WoodType type = woodTypes.findOne(Long.parseLong(request.getParameter("woodTypeId")));
		System.out.println(type.getName());
		SaleInvoiceItem item;
		try {
			item = SaleInvoiceItemsFromRequest.getSaleItemFromRequest(request, type);
		} catch (NumberFormatException e) {
			model.addAttribute("errors", "Niepoprawna liczba, liczby zmiennoprzecinkowe oddzielamy kropką!");

			return "forms/addSaleInvoiceItemForm";
		} catch (IllegalArgumentException f) {
			model.addAttribute("errors", "Niepoprawny format daty poprawny format to: RRRR-MM-DD");
			return "forms/addSaleInvoiceItemForm";
		} catch (Exception g) {
			System.out.println("#####################################");
			g.printStackTrace();
			System.out.println("#####################################");
			model.addAttribute("errors", "Coś poszło nie tak, staramy się zobaczyć co");
			return "forms/addSaleInvoiceItemForm";
		}

		itemRepository.save(item);
		return "forms/addSaleInvoiceItemForm";

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSaleInvoice(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", invoiceRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteCustomer(@PathVariable Long id) {
		invoiceRepository.delete(id);
		return "redirect: /FSC/sale/";
	}

}

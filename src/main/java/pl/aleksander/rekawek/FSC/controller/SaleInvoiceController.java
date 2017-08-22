package pl.aleksander.rekawek.FSC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.aleksander.rekawek.FSC.entity.Customer;
import pl.aleksander.rekawek.FSC.repository.CustomerRepository;
import pl.aleksander.rekawek.FSC.repository.SaleInvoiceItemRepository;
import pl.aleksander.rekawek.FSC.repository.SaleInvoiceRepository;

@Controller
@RequestMapping(path = "/sale")
public class SaleInvoiceController {

	@Autowired
	private SaleInvoiceItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SaleInvoiceRepository invoiceRepository;

	@ModelAttribute(name = "customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getAllSaleInvoices(Model model) {
		model.addAttribute(invoiceRepository.findAll());
		return "views/saleInvoiceList";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateSaleInvoiceForm() {
		return "forms/createSaleInvoiceForm";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateSaleInvoiceForm(HttpServletRequest request){
		return "redirect: ./";
	}

}

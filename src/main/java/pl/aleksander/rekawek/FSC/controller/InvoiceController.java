package pl.aleksander.rekawek.FSC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.aleksander.rekawek.FSC.entity.Invoice;
import pl.aleksander.rekawek.FSC.entity.InvoiceItem;
import pl.aleksander.rekawek.FSC.entity.Supplier;
import pl.aleksander.rekawek.FSC.repository.InvoiceItemRepository;
import pl.aleksander.rekawek.FSC.repository.InvoiceRepository;
import pl.aleksander.rekawek.FSC.repository.SupplierRepository;

@Controller
@RequestMapping(path = "/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private InvoiceItemRepository invoiceItemsRepository;

	@ModelAttribute(name = "suppliers")
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getInvoceList(Model model) {
		model.addAttribute("invoices", invoiceRepository.findAll());
		return "views/invoiceList";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateInvoiceForm(Model model) {

		model.addAttribute("invoice", new Invoice());
		return "forms/createInvoiceForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateInvoiceForm(@Validated @ModelAttribute Invoice invoice, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createInvoiceForm";
		} else {
			invoiceRepository.save(invoice);
			model.addAttribute("invoice", invoiceRepository.findOne(invoice.getId()));
//			model.addAttribute("invoiceItem", new InvoiceItem());
			return "redirect: /FSC/invoice/add/Item";
		}

	}

	@RequestMapping(path = "/add/Item", method = RequestMethod.GET)
	public String addInvoiceItem(@ModelAttribute Invoice invoice, Model model) {
		model.addAttribute("invoice", invoice);
		model.addAttribute("invoiceItem", new InvoiceItem());
		
		return "forms/addInvoiceItems";
	}
	
	@RequestMapping(path = "/add/Item", method = RequestMethod.POST)
	public String processAddInvoiceItem(@Validated @ModelAttribute InvoiceItem invoiceItem, BindingResult result){
		if(result.hasErrors()){
			return "forms/addInvoiceItems";
		} else {
			invoiceItemsRepository.save(invoiceItem);
			return "./";
		}
	}
	
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateInvoiceForm(@PathVariable Long id, Model model) {
		model.addAttribute("invoice", invoiceRepository.findOne(id));
		return "forms/createInvoiceForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateInvoiceForm(@Validated @ModelAttribute Invoice invoice, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createInvoiceForm";
		} else {
			invoiceRepository.save(invoice);
			return "redirect: ../";
		}

	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteInvoiceRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", invoiceRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteInvoice(@PathVariable Long id) {
		invoiceRepository.delete(id);
		return "redirect: /FSC/invoice/";
	}
}

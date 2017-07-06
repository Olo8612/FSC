package pl.aleksander.rekawek.FSC.controller;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;

import pl.aleksander.rekawek.FSC.entity.Invoice;
import pl.aleksander.rekawek.FSC.entity.InvoiceItem;
import pl.aleksander.rekawek.FSC.entity.Magazine;
import pl.aleksander.rekawek.FSC.repository.InvoiceItemRepository;
import pl.aleksander.rekawek.FSC.repository.InvoiceRepository;
import pl.aleksander.rekawek.FSC.repository.MagazineRepository;

@Controller
@RequestMapping(path = "/magazine")
public class MagazineController {

	@Autowired
	private MagazineRepository magazineRepository;

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@ModelAttribute(name = "invoices")
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateMagazineForm(Model model) {
		model.addAttribute("magazine", new Magazine());
		return "forms/createMagazineForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateMagazineForm(@Validated @ModelAttribute Magazine magazine, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createMagazineForm";
		} else {
			List<InvoiceItem> invoice = invoiceItemRepository.findInvoiceItemPlainWood(magazine.getInvoice().getId());
			Long quantCm = 0L;
			Long quantGrams = 0L;
			for (InvoiceItem invoiceItem : invoice) {
				quantCm += invoiceItem.getQuantityCm3();
				quantGrams += invoiceItem.getQuantityGrams();
			}
			magazine.setQuantityCm3(quantCm);
			magazine.setQuantityGrams(quantGrams);
			magazineRepository.save(magazine);
			return "redirect: ./";
		}
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getMagazinesList(Model model) {
		model.addAttribute("magazine", magazineRepository.findAll());
		return "views/magazineList";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateMagazineForm(@PathVariable Long id, Model model) {
		model.addAttribute("magazine", magazineRepository.findOne(id));
		return "forms/createMagazineForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateMagazineForm(@Validated @ModelAttribute Magazine magazine, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createMagazineForm";
		} else {
			magazineRepository.save(magazine);
			return "redirect: ../";
		}

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteMagazineRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", magazineRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteMagazine(@PathVariable Long id) {
		magazineRepository.delete(id);
		return "redirect: /FSC/magazine/";
	}

}

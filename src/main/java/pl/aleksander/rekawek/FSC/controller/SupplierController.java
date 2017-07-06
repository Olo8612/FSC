package pl.aleksander.rekawek.FSC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.aleksander.rekawek.FSC.entity.Supplier;
import pl.aleksander.rekawek.FSC.repository.SupplierRepository;

@Controller
@RequestMapping(path = "/supplier")
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateSupplierForm(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "forms/createSuplierForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateSupplierForm(@Validated @ModelAttribute Supplier supplier, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createSuplierForm";
		} else {
			supplierRepository.save(supplier);
			return "redirect: ./";
		}
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getSuppliersList(Model model) {
		model.addAttribute("suppliers", supplierRepository.findAll());
		return "views/suppliersList";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateSupplierForm(@PathVariable Long id, Model model) {
		model.addAttribute("supplier", supplierRepository.findOne(id));
		return "forms/createSuplierForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateSupplierForm(@Validated @ModelAttribute Supplier supplier, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createSuplierForm";
		} else {
			supplierRepository.save(supplier);
			return "redirect: ../";
		}

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSupplierRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", supplierRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteSupplier(@PathVariable Long id) {
		supplierRepository.delete(id);
		return "redirect: /FSC/supplier/";
	}

}

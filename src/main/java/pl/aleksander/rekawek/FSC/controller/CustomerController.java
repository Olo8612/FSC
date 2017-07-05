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

import pl.aleksander.rekawek.FSC.entity.Customer;
import pl.aleksander.rekawek.FSC.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getCreateCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "forms/createCustomerForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateCustomerForm(@Validated @ModelAttribute Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createCustomerForm";
		} else {
			customerRepository.save(customer);
			return "redirect: ./";
		}
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getCustomersList(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "views/customersList";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerRepository.findOne(id));
		return "forms/createCustomerForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateCustomerForm(@Validated @ModelAttribute Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createCustomerForm";
		} else {
			customerRepository.save(customer);
			return "redirect: ../";
		}

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomerRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", customerRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteCustomer(@PathVariable Long id) {
		customerRepository.delete(id);
		return "redirect: /FSC/customer/";
	}

}

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

import pl.aleksander.rekawek.FSC.entity.WoodType;
import pl.aleksander.rekawek.FSC.repository.WoodTypeRepository;

@Controller
@RequestMapping(path="/woodType")
public class WoodTypeController {

	@Autowired
	public WoodTypeRepository woodTypeRepository;
	
	@RequestMapping(path="/", method= RequestMethod.GET)
	public String getWoodTypeList(Model model){
		model.addAttribute("woodType", woodTypeRepository.findAll());
		return "views/woodTypeList";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String getCreateWoodTypeForm(Model model){
		model.addAttribute("woodType", new WoodType());
		return "forms/createWoodTypeForm";
		
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processCreateWoodTypeForm(@Validated @ModelAttribute WoodType woodType, BindingResult result,
			Model model){
		if (result.hasErrors()){
			return "forms/createWoodTypeForm";
		} else {
			woodTypeRepository.save(woodType);
			return "redirect: ./";
		}
		
	}
	
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getUpdateWoodTypeForm(@PathVariable Long id, Model model) {
		model.addAttribute("woodType", woodTypeRepository.findOne(id));
		return "forms/createSuplierForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processUpdateWoodTypeForm(@Validated @ModelAttribute WoodType woodType, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "forms/createSuplierForm";
		} else {
			woodTypeRepository.save(woodType);
			return "redirect: ../";
		}

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteWoodTypeRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", woodTypeRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteWoodType(@PathVariable Long id) {
		woodTypeRepository.delete(id);
		return "redirect: /FSC/woodType/";
	}

}

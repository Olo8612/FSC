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

import pl.aleksander.rekawek.FSC.entity.Magazine;
import pl.aleksander.rekawek.FSC.entity.ProductionCard;
import pl.aleksander.rekawek.FSC.repository.MagazineRepository;
import pl.aleksander.rekawek.FSC.repository.MagazineToProductionRepository;
import pl.aleksander.rekawek.FSC.repository.ProductionCardRepository;
import pl.aleksander.rekawek.FSC.service.ProductionCardDelete;
import pl.aleksander.rekawek.FSC.service.ProductionCardFromRequest;

@Controller
@RequestMapping(path = "/production")
public class ProductionCardController {

	@Autowired
	private ProductionCardRepository productionCardRepository;

	@Autowired
	private MagazineRepository magazineRepository;

	@Autowired
	private MagazineToProductionRepository mProductionRepository;

	@ModelAttribute(name = "magazines")
	public List<Magazine> getMagazinePositions() {
		return magazineRepository.findAll();
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getProductionCardList(Model model) {
		model.addAttribute("productionCards", productionCardRepository.findAll());
		return "views/productionList";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getProductionCardCreateForm(Model model) {
		return "forms/createProductionCardForm";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String processProductionCardCreateForm(HttpServletRequest request, Model model) {
		Magazine magazine = magazineRepository.findOne(Long.parseLong(request.getParameter("magazine")));
		ProductionCardFromRequest cardFromRequest = new ProductionCardFromRequest(magazine);
		
		try{
		cardFromRequest.createProductionCardFromRequestParams(request);
		} catch(NumberFormatException e){
			model.addAttribute("errors", "Nieprawidłowy format wprowadzonej ilości surowca");
			return "forms/createProductionCardForm";			
		} catch(IllegalArgumentException f){
			f.printStackTrace();
			model.addAttribute("errors", "Nieprawidłowy format daty, prawidłowy format to RRRR-MM-DD");
			return "forms/createProductionCardForm";
		}
		magazineRepository.save(cardFromRequest.getMagazine());
		mProductionRepository.save(cardFromRequest.getmProduction());
		productionCardRepository.save(cardFromRequest.getCard());
			
		return "redirect: ./";
		
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomerRequest(@PathVariable Long id, Model model) {
		model.addAttribute("confirmation", productionCardRepository.findOne(id));
		return "views/confirmationDialog";
	}

	@RequestMapping(path = "/delete/{id}/yes", method = RequestMethod.GET)
	public String processDeleteCustomer(@PathVariable Long id, Model model) {
		ProductionCard card = productionCardRepository.findOne(id);
		ProductionCardDelete toDelete = new ProductionCardDelete(card);
		Magazine magazine = toDelete.restoreMagazinePositions();
		magazineRepository.save(magazine);
		productionCardRepository.delete(id);
		return "redirect: /FSC/production/";
	}
	
	

}

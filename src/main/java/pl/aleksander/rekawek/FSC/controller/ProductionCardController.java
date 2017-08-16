package pl.aleksander.rekawek.FSC.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.aleksander.rekawek.FSC.entity.Magazine;
import pl.aleksander.rekawek.FSC.entity.MagazineToProduction;
import pl.aleksander.rekawek.FSC.entity.ProductionCard;
import pl.aleksander.rekawek.FSC.repository.MagazineRepository;
import pl.aleksander.rekawek.FSC.repository.MagazineToProductionRepository;
import pl.aleksander.rekawek.FSC.repository.ProductionCardRepository;
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
	public String processProductionCardCreateForm(HttpServletRequest request) {
		Magazine magazine = magazineRepository.findOne(Long.parseLong(request.getParameter("magazine")));
		ProductionCardFromRequest cardFromRequest = new ProductionCardFromRequest(magazine);

		if (cardFromRequest.createProductionCardFromRequestParams(request) != null) {
			return "forms/createProductionCardForm";
		} else {
			magazineRepository.save(cardFromRequest.getMagazine());
			mProductionRepository.save(cardFromRequest.getmProduction());
			productionCardRepository.save(cardFromRequest.getCard());
			
			return "views/productionList";
		}
	}

}

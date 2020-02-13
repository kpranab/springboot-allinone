package com.spring.allinone.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.allinone.travel.model.Travel;
import com.spring.allinone.travel.model.TravelDto;
import com.spring.allinone.travel.repository.TravelRepository;

@Controller
public class TravelController {

	@Autowired
	private TravelRepository travelRepository;

	@RequestMapping("/travel/all")
	public String indexView(Model model) {
		model.addAttribute("travelList", travelRepository.findAll());
		return "allTravels";
	}

	@GetMapping("/travel/createTravel")
	public String travelForm(Model model) {
		model.addAttribute("travelDto", new TravelDto());
		return "createTravel";
	}

	@PostMapping("/travel/saveTravel")
	public String travelSubmit(@ModelAttribute TravelDto travelDto, Model model) {
		travelRepository.save(new Travel(travelDto.getUserId(), travelDto.getSource(), travelDto.getDestination()));
		model.addAttribute("travelList", travelRepository.findAll());
		return "allTravels";
	}

}

package com.spring.allinone.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.allinone.travel.model.TravelDto;
import com.spring.allinone.travel.repository.ReactiveTravelRepository;

import reactor.core.publisher.Mono;

@RestController
public class ReactiveTravelController {

	private final ReactiveTravelRepository reactiveTravelRepository;

	@Autowired
	public ReactiveTravelController(ReactiveTravelRepository reactiveTravelRepository) {
		this.reactiveTravelRepository = reactiveTravelRepository;
	}
	
	@GetMapping("/reactive/travel/{userId}")
	public Mono<List<TravelDto>> getTravels(@PathVariable final String userId){
		return reactiveTravelRepository.getTravels(userId);
	}
	
	@PostMapping(value = "/reactive/travel",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<TravelDto> addTravel(@RequestBody TravelDto travel){
		return reactiveTravelRepository.addTravel(travel);
	}
}

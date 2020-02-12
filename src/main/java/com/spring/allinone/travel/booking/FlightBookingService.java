package com.spring.allinone.travel.booking;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.allinone.travel.configuration.BookingServiceSettings;
import com.spring.allinone.travel.model.Travel;
import com.spring.allinone.travel.repository.TravelRepository;

@Component
public class FlightBookingService implements BookingService {

	private static final Logger log = LoggerFactory.getLogger(FlightBookingService.class.getName());

	/*@Autowired
	BookingServiceSettings bookingServiceSettings;
	
	@Autowired
	TravelRepository travelRepository;*/
	
	private final BookingServiceSettings bookingServiceSettings;
	private final TravelRepository travelRepository;

	@Autowired
	public FlightBookingService(BookingServiceSettings bookingServiceSettings, TravelRepository travelRepository) {
		this.bookingServiceSettings = bookingServiceSettings;
		this.travelRepository = travelRepository;
	}

	@Override
	public boolean book(Travel travel) {
		if(bookingServiceSettings.getSupportedDestinations().contains(travel.getDestination())) {
			travelRepository.save(travel);
			return true;
		}
		return false;
	}
	
	@PostConstruct
	public void init() {
		log.info("Inside init method of @PostConstruct");
	}
	
	@PreDestroy
	public void cleanup() {
		log.info("Inside cleanup method. Possible to release some resorces @PreDestroy");
	}

}

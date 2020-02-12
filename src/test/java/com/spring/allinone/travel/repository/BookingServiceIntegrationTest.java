package com.spring.allinone.travel.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.allinone.travel.booking.BookingService;
import com.spring.allinone.travel.model.Travel;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceIntegrationTest {
	
	@Autowired
	BookingService bookingService;

	@Test
	public void shouldBookATravel() {
		bookingService.book(new Travel("pranab","LONDON","PARIS"));
	}
}

package com.spring.allinone.travel.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		boolean bookingStatus = bookingService.book(new Travel("pranab","LONDON","PARIS"));
		assertEquals(bookingStatus, true);
	}
}

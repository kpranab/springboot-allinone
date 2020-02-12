package com.spring.allinone.travel.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.allinone.travel.model.Travel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelRepositoryIntegrationTest {

	@Autowired
	TravelRepository travelRepository;

	@Test
	public void shouldSaveTravelAndRetrieveItByUserId() {

		// Given
		String userId = "Pranab";
		Travel travel = new Travel(userId, "LONDON", "PARIS");

		// When
		travelRepository.save(travel);
		List<Travel> travels = travelRepository.findByUserId(userId);

		// Then
		assertThat(travels.get(0).getSource()).isEqualTo("LONDON");
		assertThat(travels.get(0).getDestination()).isEqualTo("PARIS");
	}

	@Test
	public void shouldRetrieveAllTravelesThatHaveBarcelonaAsDestionation() {

		// Given
		List<Travel> travels = Arrays.asList(new Travel(UUID.randomUUID().toString(), "LONDAN", "BARCELONA"),
				new Travel(UUID.randomUUID().toString(), "AMSTERDAM", "LONDON"),
				new Travel(UUID.randomUUID().toString(), "AMSTERDAM", "BARCELONA"),
				new Travel(UUID.randomUUID().toString(), "PARIS", "MADRID"));

		// When
		travelRepository.saveAll(travels);
		List<Travel> foundTravels = travelRepository.findByDestination("BARCELONA");

		// Then
		assertThat(foundTravels.size()).isEqualTo(2);
	}
}

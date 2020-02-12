package com.spring.allinone.travel.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.allinone.travel.model.TravelDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveTravelControllerIntegrationTest {

	@Test
	public void shouldCreateAndRetrieveTravel() {

		// Given
		RestTemplate restTemplate = new RestTemplate();
		TravelDto travelDto = new TravelDto(UUID.randomUUID().toString(), "SRC", "DST");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TravelDto> httpEntity = new HttpEntity<>(travelDto, httpHeaders);

		// When
		ResponseEntity<TravelDto> postResponse = restTemplate.postForEntity("http://localhost:2020/reactive/travel",
				httpEntity, TravelDto.class);

		// Then
		assertThat(postResponse.getStatusCode().value()).isEqualTo(200);
		assertThat(postResponse.getBody()).isNotNull();

		// When
		List<TravelDto> getResponse = restTemplate.exchange("http://localhost:2020/reactive/travel/" + postResponse.getBody().getUserId(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<TravelDto>>() {
				}).getBody();
		
		//Then
		assertThat(getResponse.size()).isGreaterThan(0);
	}
}

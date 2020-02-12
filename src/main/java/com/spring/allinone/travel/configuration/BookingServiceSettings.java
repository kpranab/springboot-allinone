package com.spring.allinone.travel.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pranab
 *
 */
@Component
@ConfigurationProperties(prefix="travel-config")
public class BookingServiceSettings {
	
	private List<String> supportedDestinations;

	public List<String> getSupportedDestinations() {
		return supportedDestinations;
	}

	public void setSupportedDestinations(List<String> supportedDestinations) {
		this.supportedDestinations = supportedDestinations;
	}

}

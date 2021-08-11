package com.maersk.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.maersk.demo.service.PingService;

class PingServiceTDDTest {

	PingService pingService = new PingService();

	@Test
	void ping_success() {
		PingResponse response = pingService.ping();
		assertNotNull(response, "PingResponse can't be null");
		assertNotNull(response.getDate(), "PingResponse Date can't be null");
		Assertions.assertThrows(RuntimeException.class, () -> pingService.ping());
	}

}

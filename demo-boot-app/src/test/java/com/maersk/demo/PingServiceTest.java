package com.maersk.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import com.maersk.demo.service.PingService;
import org.junit.jupiter.api.Test;

class PingServiceTest {

	private PingService pingService = new PingService();

	@Test
	void ping() {
		LocalDate expected = LocalDate.now();
		PingResponse actual = pingService.ping();
		assertNotNull(actual, "PingResponse can't be null");
		assertEquals(expected, actual.getDate());
	}

}
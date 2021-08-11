package com.maersk.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApiTest {

	private TestRestTemplate testRestTemplate = new TestRestTemplate();

	@LocalServerPort
	int port;

	@Test
	void ping() {
		PingResponse response = testRestTemplate.getForObject("http://localhost:" + port + "/ping", PingResponse.class);
        assertNotNull(response, "PingResponse can't be null");
        assertNotNull(response.getDate(), "PingResponse Date can't be null");
	}

}
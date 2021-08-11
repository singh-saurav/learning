package com.maersk.demo;

import com.maersk.demo.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoApi {

	private final PingService pingService;

	@Autowired
	public DemoApi(PingService pingService) {
		this.pingService = pingService;
	}

	@GetMapping("/ping")
	public ResponseEntity<PingResponse> ping() {
		log.info("started ping");
		return ResponseEntity.ok().body(pingService.ping());
	}

}

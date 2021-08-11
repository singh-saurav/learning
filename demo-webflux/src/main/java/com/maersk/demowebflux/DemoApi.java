package com.maersk.demowebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class DemoApi {

	private final PingService pingService;

	@Autowired
	public DemoApi(PingService pingService) {
		this.pingService = pingService;
	}

	@GetMapping("/ping")
	public Mono<PingResponse> ping() {
		log.info("started ping");
		Mono<PingResponse> responseMono = pingService.ping();
		responseMono.map(r -> r.getDate()).doFinally(System.out::println);
		return responseMono;
	}

}

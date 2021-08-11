package com.maersk.demo.service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import com.maersk.demo.PingResponse;
import org.springframework.stereotype.Service;

@Service
public class PingService {

	AtomicInteger integer = new AtomicInteger(1);

	public PingResponse ping() {
		PingResponse response = new PingResponse("Test", LocalDate.now());
		if (integer.getAndIncrement() % 2 == 0) {
			throw new RuntimeException("I found even number");
		}
		return response;
	}

}

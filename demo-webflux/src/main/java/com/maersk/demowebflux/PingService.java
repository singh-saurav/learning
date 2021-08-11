package com.maersk.demowebflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class PingService {

    public Mono<PingResponse> ping() {
        return Mono.delay(Duration.ofSeconds(10)).then(Mono.just(new PingResponse("Hello", LocalDate.now())));
    }
}
